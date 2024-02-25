package com.chatroom.chatroompractice.services

import com.chatroom.chatroompractice.models.CreateUserRequest
import com.chatroom.chatroompractice.models.User
import com.chatroom.chatroompractice.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository
    fun getAllEmployees(): MutableList<User> {
        return userRepository.findAll()
    }

    fun saveUser(user: CreateUserRequest): User {
        val newUser = User(username = user.username, email = user.email, picture = user.picture)
        return userRepository.save(newUser)
    }
}