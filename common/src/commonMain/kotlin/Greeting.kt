package com.todora.common

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${platformName()}"
}