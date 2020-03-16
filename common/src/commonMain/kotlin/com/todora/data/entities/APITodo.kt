package com.todora.data.entities

import com.todora.common.com.todora.domain.entities.Todo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APITodo(
    @SerialName("_id")
    val id: String,
    val description: String,
    val done: Boolean
)

fun APITodo.map(): Todo {
    return Todo(id, description, 1L, done)

}