package com.todora.common

class GetTodoraInteractor(private val todoRepository: TodoRepository) : Interactor<String, Todo> {

    override suspend fun execute(params: String): Todo {
        return todoRepository.create(params)
    }
}