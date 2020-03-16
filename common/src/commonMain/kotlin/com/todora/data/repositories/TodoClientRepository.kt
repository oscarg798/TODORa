package com.todora.common.com.todora.data

import TodoService
import com.todora.common.com.todora.domain.entities.Todo
import com.todora.common.com.todora.domain.repositories.TodoRepository
import com.todora.data.entities.map

class TodoClientRepository(private val todoService: TodoService) : TodoRepository {

    override suspend fun create(description: String): Todo {
        return Todo(
            "1",
            description,
            1L,
            false
        )
    }

    override suspend fun getTodos(): List<Todo> {
        return todoService.getTodos().map {
            it.map()
        }
    }
}