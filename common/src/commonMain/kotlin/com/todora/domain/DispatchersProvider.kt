package com.todora.common.com.todora.domain

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {

    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val computation: CoroutineDispatcher
}