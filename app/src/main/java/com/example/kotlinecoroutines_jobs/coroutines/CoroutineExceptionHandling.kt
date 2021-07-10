package com.example.kotlinecoroutines_jobs.coroutines

import kotlinx.coroutines.*

fun main()= runBlocking{
    println("Name of Thread ${Thread.currentThread().name}")
    val job: Job =launch {
        try{
            for(i in 0..500){
                println(i)
                delay(10)
            }
        }catch (e:CancellationException){
            println("${e.printStackTrace()}")
        }
    }
    delay(50)
    job.cancel()
    job.join()
}