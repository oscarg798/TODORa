package com.todora.common.com.todora.domain.interactors

import com.todora.common.com.todora.domain.entities.Todo
import com.todora.common.com.todora.domain.base.Interactor
import com.todora.common.com.todora.domain.repositories.TodoRepository

class CreateTodoInteractor(private val todoRepository: TodoRepository) :
    Interactor<String, Todo> {

    override suspend fun execute(params: String): Todo {
        return todoRepository.create(params)
    }
}