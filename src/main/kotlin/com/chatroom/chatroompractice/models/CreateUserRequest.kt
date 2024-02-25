package com.chatroom.chatroompractice.models

data class CreateUserRequest(
        var username: String,
        var email: String,
        var picture: String,
)