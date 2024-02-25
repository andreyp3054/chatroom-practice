package com.chatroom.chatroompractice.dto

data class CreateUserRequest(
        var username: String,
        var email: String,
        var picture: String,
)