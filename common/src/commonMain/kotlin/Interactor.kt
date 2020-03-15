package com.todora.common

interface Interactor<Params, Response> {

    suspend fun execute(params: Params): Response
}