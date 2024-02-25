package com.chatroom.chatroompractice.controllers

import com.chatroom.chatroompractice.dto.MessageResponse
import com.chatroom.chatroompractice.dto.NewChatRequest
import com.chatroom.chatroompractice.models.Message
import com.chatroom.chatroompractice.services.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("chat")  //localhost:8080/chat
class ChatController {

    @Autowired //inject
    lateinit var chatService: ChatService

    @PostMapping("new") //localhost:8080/chat/new
    fun newChatMessage(@RequestBody newChatRequest: NewChatRequest): Message {
        return chatService.newChatMessage(newChatRequest)
    }

    @GetMapping("messages") //localhost:8080/chat/messages
    fun getAllMessages(): List<MessageResponse> {
        var templist = chatService.getAllMessages()
        return listConverter(templist)

    }

    fun listConverter(messageList: MutableList<Message>): List<MessageResponse> {
        var messageResponseList = mutableListOf<MessageResponse>()
        for (m in messageList) {
            messageResponseList.add(MessageResponse(message = m.value, userId = m.user.id, chatroomId = m.chatroom.id, time = m.time))
        }
        return messageResponseList
    }

    @GetMapping("chit")
    fun sample(): String {
        return "testing"
    }
}