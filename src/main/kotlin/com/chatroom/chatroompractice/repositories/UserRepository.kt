package com.chatroom.chatroompractice.repositories

import com.chatroom.chatroompractice.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> { // parameter : entity and primary key type
}