package com.todora.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


interface View {

    fun show(todo: Todo)
}

interface Presenter {

    var view: View?

    fun bind(view: View)

    fun create(description: String)
}

class TodoPresenter(private val todoraInteractor: GetTodoraInteractor) : Presenter {


    override var view: View? = null

    override fun bind(view: View) {
        this.view = view
    }

    override fun create(description: String) {
        CoroutineScope(Main).launch {
            val todo = withContext(Background){
                todoraInteractor.execute(description)
            }
            view?.show(todo)
        }
    }
}