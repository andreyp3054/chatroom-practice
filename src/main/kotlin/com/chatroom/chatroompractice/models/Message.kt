package com.chatroom.chatroompractice.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
data class Message(
        @Id
        @GeneratedValue
        var id: Long = -1,
        var value: String,
        var time: Date
) {
    @ManyToOne // a user can have many messages
    lateinit var user: User

    @ManyToOne // multiple messages have only a chatroom
    lateinit var chatroom: Chatroom //The chatroom does not exist yet and
}