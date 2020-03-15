package com.todora.common

data class Todo(
    val id: String,
    val todoDescription: String,
    val createdAt: Long,
    val done: Boolean
)