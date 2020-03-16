package com.todora.common.com.todora.presentation.createtodo

import com.todora.common.com.todora.domain.entities.Todo
import com.todora.common.com.todora.presentation.base.BaseContract

interface CreateTodoContract {

    interface View : BaseContract.BaseView {
        fun show(todos: List<Todo>)
        fun show(todo: Todo)
    }

    interface Presenter : BaseContract.BasePresenter<View> {

        fun create(description: String)
    }
}