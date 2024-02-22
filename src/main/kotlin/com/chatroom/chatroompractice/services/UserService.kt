package com.chatroom.chatroompractice.services

import com.chatroom.chatroompractice.models.User
import org.springframework.stereotype.Service

@Service
class UserService {

    fun getAllEmployees(){

    }

    fun saveUser(user: User): User{
        return user
    }
}