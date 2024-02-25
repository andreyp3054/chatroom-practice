package com.chatroom.chatroompractice.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "app_user") // very important
class User(             //note: User is a reserved keyword in postgresql thats why @Table is added to specify
        @Id
        @GeneratedValue
        var id: Long = -1,
        var username: String,
        var email: String,
        var picture: String
) {
        @ManyToMany  //a chatroom can have many users and users can have many chatrooms
        var chatrooms: List<Chatroom> = listOf()
}

