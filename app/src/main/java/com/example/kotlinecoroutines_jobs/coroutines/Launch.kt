package com.example.kotlinecoroutines_jobs.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking{
    println("Name of Thread ${Thread.currentThread().name}")
    launch {  // this coroutines not the block of main because its inherited from parent coroutine
        //  which are runblocking thread
        println("Name of thread before Delay Time ${Thread.currentThread().name}")
        delay(2000)
        println("Name of thread after Delay Time ${Thread.currentThread().name}" )
    }
    println("Name of thread ${Thread.currentThread().name}")
}

