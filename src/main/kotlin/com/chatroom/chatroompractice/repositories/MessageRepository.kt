package com.chatroom.chatroompractice.repositories

import com.chatroom.chatroompractice.models.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : JpaRepository<Message, Long> {
}