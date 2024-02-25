package com.chatroom.chatroompractice.dto


data class NewChatRequest(val chatroomName: String,
                          var userId: Long,
                          var message: String)