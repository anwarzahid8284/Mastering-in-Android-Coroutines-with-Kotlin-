package com.example.kotlinecoroutines_jobs.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinecoroutines_jobs.R
import com.example.kotlinecoroutines_jobs.models.StudentModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.coroutines.CoroutineContext

class SimpleCoroutineActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var job: Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        job = Job()
        buttonID.setOnClickListener {
            CoroutineScope(IO).launch {
                // here its background thread (doInBackground)
                val firstResult: String = coroutineInBackgroundThread("Hello Coroutines FirstOne")
                setTextOnMainThread(firstResult)
                val secondResult: String = coroutineInBackgroundThread("Hello coroutines SecondOne")
                setTextOnMainThread(secondResult)
            }
        }
        launch {
            val userOne = async(Dispatchers.IO) { fetchStudent() }
            val userTwo = async(Dispatchers.IO) { fetchStudent() }
            displayAllUser(userOne.await(), userTwo.await())
        }
    }

    private suspend fun coroutineInBackgroundThread(message: String): String {
        // background result return after one second
        delay(1000)
        return message
    }

    private suspend fun setTextOnMainThread(str: String) {
        withContext(Main) {
            // here its main thread (onPostExecute)
            showTextViewID.text = str
        }
    }

    private fun fetchStudent(): StudentModel {
        // TODO something here and return the result
        return fetchStudent()

    }

    private fun displayAllUser(firstStudentModel: StudentModel, secondStudent: StudentModel) {

    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()

    }
}