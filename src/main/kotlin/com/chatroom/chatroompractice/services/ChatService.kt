package com.chatroom.chatroompractice.services

import com.chatroom.chatroompractice.dto.NewChatRequest
import com.chatroom.chatroompractice.models.Chatroom
import com.chatroom.chatroompractice.models.Message
import com.chatroom.chatroompractice.models.User
import com.chatroom.chatroompractice.repositories.ChatroomRepository
import com.chatroom.chatroompractice.repositories.MessageRepository
import com.chatroom.chatroompractice.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatService {

    @Autowired
    lateinit var chatroomRepository: ChatroomRepository

    @Autowired
    lateinit var messageRepository: MessageRepository

    @Autowired
    lateinit var userRepository: UserRepository

    fun newChatMessage(newChat: NewChatRequest): Message {
        val newMessage = Message(value = newChat.message, time = Date())

        //check if the chatroom exists
        val chatroom = chatroomRepository.findByName(newChat.chatroomName) //finds the corresponding chatroom from the repository

        newMessage.chatroom = chatroom.orElseGet {
            chatroomRepository.save(Chatroom(name = newChat.chatroomName, iconUrl = "default.jpg"))
        }

        // Check if the user exists
        val user = userRepository.findById(newChat.userId)
        // Set the owner of the message
        newMessage.user = user.orElseThrow {
            // Throw an exception indicating that the user does not exist
            NoSuchElementException("User with ID ${newChat.userId} not found")
        }

        return messageRepository.save(newMessage)
    }


    //OLD CODE FOR newChatMessage
    //check if the chatroom exists
//        val chatroom = chatroomRepository.findByName(newChat.chatroomName) //finds the corresponding chatroom from the repository
//            if (chatroom.isPresent) {
//                newMessage.chatroom = chatroom.get() // set the chatroom of the new message to its corresponding chatroom
//            } else {        // if it does not exist, create a new chatroom
//                val newChatroom = chatroomRepository.save(
//                        Chatroom(name = newChat.chatroomName, iconUrl = "default.png")
//                )
//            }

//        //check if user exists
//        val temp: Optional<User> = userRepository.findById(newChat.userId)
//        //set the owner of the message
//        if (temp.isPresent) {
//            newMessage.user = temp.get()
//        } else {
//            //Throw an error indicating no
//        }


    fun getAllMessages(): MutableList<Message> {
        return messageRepository.findAll()
    }


}