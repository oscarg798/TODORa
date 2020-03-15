package com.todora.common

interface TodoRepository  {

    suspend fun create(description: String): Todo
}