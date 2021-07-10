package com.example.kotlinecoroutines_jobs.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("start")
    val time = measureTimeMillis {
        val firstftn = async { firstFun() }
        val secondftn = async { secondFun() }
        println("${firstftn.await()},${secondftn.await()}")
    }
    println("concurrent function completed in $time millisconds")
    println("end")
}

private suspend fun firstFun() {
    delay(100)
    print("Welcome to ")
}

private suspend fun secondFun() {
    delay(200)
    println("Developersol")
}