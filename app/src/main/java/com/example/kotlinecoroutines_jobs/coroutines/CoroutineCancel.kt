package com.example.kotlinecoroutines_jobs.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking{
    println("Name of Thread ${Thread.currentThread().name}")
    val job: Job =launch {  // this coroutines not the block of main because its inherited from parent coroutine
        for(i in 0..500){
            println(i)
            delay(50)// cooperative
           // Thread.sleep(50)// not Cooperative
        }
    }
    delay(200)
    print("$job")
    job.cancel()
    job.join()
    println("$job")
}
