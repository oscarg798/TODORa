package com.todora.common.com.todora.presentation.base

import com.todora.common.com.todora.domain.DispatchersProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

interface BaseContract {

    interface BaseView

    interface BasePresenter<View : BaseView> {

        var view: View?
        var parentJob: Job
        var dispatchersProvider: DispatchersProvider

        fun bind(view: View) {
            this.view = view
        }

        fun unbind() {
            parentJob.apply {
                cancelChildren()
                cancel()
            }
            this.view = null
        }

        fun perform(block: suspend CoroutineScope.() -> Unit) {
            CoroutineScope(dispatchersProvider.main + parentJob).launch {
                block()
            }
        }

    }
}