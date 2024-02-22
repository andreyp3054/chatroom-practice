package com.chatroom.chatroompractice.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class User(
        @Id
        @GeneratedValue
        var id: Long = -1,
        var username: String,
        var email: String,
        var picture: String
)