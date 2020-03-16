package com.todora.common.com.todora.domain.repositories

import com.todora.common.com.todora.domain.entities.Todo

interface TodoRepository {

    suspend fun create(description: String): Todo

    suspend fun getTodos(): List<Todo>
}