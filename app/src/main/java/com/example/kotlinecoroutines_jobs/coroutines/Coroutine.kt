package com.example.kotlinecoroutines_jobs.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    println("Name of Thread ${Thread.currentThread().name}")
    GlobalScope.launch {  // this coroutines not the block of background thread
        println("Name of thread before Delay Time ${Thread.currentThread().name}")
        delay(1000)
        println("Name of thread after Delay Time ${Thread.currentThread().name}" )
    }
    runBlocking { // this coroutines block the main thread
        delay(2000)
    }
    println("Name of thread ${Thread.currentThread().name}")
}