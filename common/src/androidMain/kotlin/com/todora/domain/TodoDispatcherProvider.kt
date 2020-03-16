package com.todora.common.com.todo.domain

import com.todora.common.com.todora.domain.DispatchersProvider
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class TodoDispatcherProvider: DispatchersProvider {
    actual override val main: CoroutineDispatcher = Dispatchers.Main
    actual override val io: CoroutineDispatcher = Dispatchers.IO
    actual override val computation: CoroutineDispatcher = Dispatchers.Default
}