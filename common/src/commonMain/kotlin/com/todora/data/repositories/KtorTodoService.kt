package com.todora.data.repositories

import TodoService
import com.todora.data.entities.APITodo
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import kotlinx.serialization.*
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonArraySerializer
import kotlinx.serialization.json.JsonConfiguration

class KtorTodoService : TodoService {

    private val client = HttpClient() {
    }

    override suspend fun getTodos(): List<APITodo> {
        val response = client.get<String>("http://192.168.1.13:3001/todo"){
            header("Authorization","bearer eyJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1ZTZmODBlYTZlYmRiNzdiNzBhNmU5MDgiLCJuYW1lIjoiT3NjYXIgR2FsbG9uIiwiZW1haWwiOiJvc2Nhcmc3OThAZ21haWwuY29tIiwiX192IjowfQ.bZkMrBs415eKvgBdRglzipJuCvzFVUi_q57_Q2NnCiM")
        }

        return Json(JsonConfiguration.Stable.copy(ignoreUnknownKeys = true)).parse(APITodo.serializer().list, response)
}

    override suspend fun createTodo(description: String): APITodo {
        TODO("Not yet implemented")
    }
}