package com.chatroom.chatroompractice.services

import com.chatroom.chatroompractice.models.User
import com.chatroom.chatroompractice.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository
    fun getAllEmployees() {

    }

    @PostMapping
    fun saveUser(user: User): User {
        return userRepository.save(user)
    }
}