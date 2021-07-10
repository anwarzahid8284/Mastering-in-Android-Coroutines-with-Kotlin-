package com.example.kotlinecoroutines_jobs.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("start")
    launch {   // this coroutines fully run on main thread delay not the switched the thread
        println("only launch before delay ${Thread.currentThread().name}")
        delay(10)
        println("only launch after delay ${Thread.currentThread().name}")

    }
    launch(Dispatchers.IO) {
        println("launch with IO Dispatchers  before delay ${Thread.currentThread().name}")
        delay(10)
        println("launch with IO Dispatcher after delay ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        println("launch with Default Dispatchers  before delay ${Thread.currentThread().name}")
        delay(10)
        println("launch with Default Dispatcher after delay ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        println("launch with Unconfined Dispatchers  before delay ${Thread.currentThread().name}")
        delay(10)
        println("launch with Unconfined Dispatcher after delay ${Thread.currentThread().name}")
    }
    println("end")
}