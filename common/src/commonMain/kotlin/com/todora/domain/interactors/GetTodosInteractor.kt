package com.todora.domain.interactors

import com.todora.common.com.todora.domain.base.Interactor
import com.todora.common.com.todora.domain.entities.Todo
import com.todora.common.com.todora.domain.repositories.TodoRepository

class GetTodosInteractor(private val todoRepository: TodoRepository) :
    Interactor<Unit, List<Todo>> {

    override suspend fun execute(params: Unit): List<Todo> {
        return todoRepository.getTodos()
    }
}