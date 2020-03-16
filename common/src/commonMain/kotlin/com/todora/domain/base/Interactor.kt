package com.todora.common.com.todora.domain.base

interface Interactor<Params, Response> {

    suspend fun execute(params: Params): Response
}