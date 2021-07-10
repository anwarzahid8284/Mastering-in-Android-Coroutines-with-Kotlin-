package com.example.kotlinecoroutines_jobs.activities

import android.content.ContentValues.TAG
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import com.example.kotlinecoroutines_jobs.R
import kotlinx.android.synthetic.main.activity_coroutine_jobs.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.buttonID
import kotlinx.android.synthetic.main.activity_main.showTextViewID
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class CoroutineJobsActivity : AppCompatActivity() {
    private val PROGRESS_END = 100
    private val PROGRESS_START = 0
    private val PROGRESS_TIME = 5000
    private lateinit var job: CompletableJob

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_jobs)
        lifecycle.coroutineScope.launch {
            // this coroutines will be cancelled after lifecycle will be destoryed or finished
        }
        buttonID.setOnClickListener {
            if (!::job.isInitialized) {
                initjob()
            }
            progressID.startJobOrCancel(job)
        }


    }

    private fun resetjob() {
        if (job.isActive || job.isCompleted) {
            job.cancel(CancellationException("Resetting job"))
        }
        initjob()
    }

    private fun initjob() {
        buttonID.text = "Start Job #1"
        updateJobCompleteTextView("")
        job = Job()
        job.invokeOnCompletion {
            it?.message.let {
                var msg = it
                if (msg.isNullOrBlank()) {
                    msg = "Unknown cancellation error."
                }
                Log.e(TAG, "${job} was cancelled. Reason: ${msg}")
                showToast(msg)
            }
        }
        progressID.max = PROGRESS_END
        progressID.progress = PROGRESS_START
    }

    fun ProgressBar.startJobOrCancel(job: Job) {
        if (this.progress > 0) {
            Log.d(TAG, "${job} is already active. Cancelling...")
            resetjob()
        } else {
            buttonID.text = "Cancel Job #1"
            CoroutineScope(IO + job).launch {
                Log.d(TAG, "coroutine ${this} is activated with job ${job}.")

                for (i in PROGRESS_START..PROGRESS_END) {
                    delay((PROGRESS_TIME / PROGRESS_END).toLong())
                    this@startJobOrCancel.progress = i
                }
                updateJobCompleteTextView("Job is complete!")
            }
        }
    }

    private fun updateJobCompleteTextView(text: String) {
        GlobalScope.launch(Main) {
            showTextViewID.text = text
        }
        CoroutineScope(Dispatchers.Default).launch{}
    }

    private fun showToast(text: String) {
        GlobalScope.launch(Main) {
            Toast.makeText(this@CoroutineJobsActivity, text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}