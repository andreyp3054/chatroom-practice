package com.chatroom.chatroompractice.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany

@Entity
data class Chatroom(
        @Id
        @GeneratedValue
        var id: Long = -1,
        var name: String,
        var iconUrl: String,
) {
    @ManyToMany             //a chatroom can have many users and users can have many chatrooms
    var users: List<User> = listOf()

    @OneToMany      //one chatroom can have many messages
    var messages: List<Message> = listOf()
}