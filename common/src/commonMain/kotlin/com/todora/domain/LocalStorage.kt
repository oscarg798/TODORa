package com.todora.domain

interface LocalStorage {

    fun <T> save(key: String, something: T)

    fun <T> get(key: String): T
}