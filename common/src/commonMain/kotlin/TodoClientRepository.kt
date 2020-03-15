package com.todora.common

class TodoClientRepository : TodoRepository {

    override suspend fun create(description: String): Todo {
        return Todo("1", description, 1L, false)
    }
}