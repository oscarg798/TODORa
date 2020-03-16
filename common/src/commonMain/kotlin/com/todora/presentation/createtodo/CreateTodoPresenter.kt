package com.todora.common.com.todora.presentation.createtodo

import com.todora.common.com.todora.domain.interactors.CreateTodoInteractor
import com.todora.common.com.todo.domain.TodoDispatcherProvider
import com.todora.common.com.todora.domain.DispatchersProvider
import com.todora.domain.interactors.GetTodosInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoPresenter(
    private val
    createTodoInteractor: CreateTodoInteractor,
    private val getTodosInteractor: GetTodosInteractor,
    override var dispatchersProvider: DispatchersProvider = TodoDispatcherProvider()
) :
    CreateTodoContract.Presenter {

    override var view: CreateTodoContract.View? = null
    override var parentJob: Job = Job()

    override fun bind(view: CreateTodoContract.View) {
        super.bind(view)
        geTodos()
    }

    private fun geTodos() {
        perform {
            val todos = withContext(dispatchersProvider.io) {
                getTodosInteractor.execute(Unit)
            }

            this@TodoPresenter.view?.show(todos)

        }
    }

    override fun create(description: String) {
        perform {
            val todo = withContext(dispatchersProvider.io) {
                createTodoInteractor.execute(description)
            }
            view?.show(todo)
        }
    }
}