package com.chatroom.chatroompractice.controllers

import com.chatroom.chatroompractice.models.CreateUserRequest
import com.chatroom.chatroompractice.models.User
import com.chatroom.chatroompractice.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("users")
class UserController {

    @Autowired // makes sure that it injects the instance we created
    lateinit var service: UserService

//    @GetMapping("hello")
//    fun index(): MutableList<User> {
//        return service.getAllEmployees()
//    }

    @GetMapping("hi")
    fun hi(): String {
        return "hi"
    }

    @PostMapping("save")
    fun saveUser(@RequestBody user: CreateUserRequest): User {
        return service.saveUser(user)
    }
}