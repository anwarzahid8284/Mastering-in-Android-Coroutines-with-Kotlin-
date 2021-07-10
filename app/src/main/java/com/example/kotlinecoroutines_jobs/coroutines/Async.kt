package com.example.kotlinecoroutines_jobs.coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Thread name is ${Thread.currentThread().name}")
    val differeObj: Deferred<String> = async {
        println("before dalay ${Thread.currentThread().name}")
        delay(2000)
        println("after delay ${Thread.currentThread().name}")
        "Developer sol"
    }
   // val result=differeObj.await()
    println("last line  and $differeObj")
    differeObj.cancel()
    differeObj.join()// wait for finish the coroutines
    println("last line  and $differeObj")
}