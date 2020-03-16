package com.todora.common.com.todo.domain

import com.todora.common.com.todora.domain.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.*
import kotlin.coroutines.CoroutineContext

actual class TodoDispatcherProvider :
    DispatchersProvider {
    actual override val main: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())
    actual override val io: CoroutineDispatcher = main
    actual override val computation: CoroutineDispatcher = main
}

internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher() {

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}