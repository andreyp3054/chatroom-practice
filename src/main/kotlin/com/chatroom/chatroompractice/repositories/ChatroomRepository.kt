package com.chatroom.chatroompractice.repositories

import com.chatroom.chatroompractice.models.Chatroom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ChatroomRepository : JpaRepository<Chatroom, Long> {

    //create a function that checks the chatroom availability
    @Query("SELECT c FROM Chatroom c where c.name = :name")
    fun findByName(name: String): Optional<Chatroom> // may or may not return null (has a function called isPresent() that returns true or false
}