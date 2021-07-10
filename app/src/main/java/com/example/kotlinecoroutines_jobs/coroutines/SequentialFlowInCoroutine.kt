package com.example.kotlinecoroutines_jobs.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main()= runBlocking {
    println("start")
    val time= measureTimeMillis {
        firstFun()
        secondFun()
    }
    println("sequential function completed in $time millisconds")
    println("end")
}
private suspend fun firstFun(){
    delay(100)
    print("Welcome to ")
}
private suspend fun secondFun(){
    delay(200)
    println("Developersol")
}