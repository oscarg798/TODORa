package com.todora.common.com.todora.domain.entities

data class Todo(
    val id: String,
    val todoDescription: String,
    val createdAt: Long,
    val done: Boolean
)