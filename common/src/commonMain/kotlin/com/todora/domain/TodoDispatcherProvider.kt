package com.todora.common.com.todo.domain

import com.todora.common.com.todora.domain.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher

expect class TodoDispatcherProvider() : DispatchersProvider {
    override val main: CoroutineDispatcher
    override val io: CoroutineDispatcher
    override val computation: CoroutineDispatcher
}