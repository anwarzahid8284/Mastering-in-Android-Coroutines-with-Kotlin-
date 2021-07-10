package com.example.kotlinecoroutines_jobs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.kotlinecoroutines_jobs.models.StudentModel
import kotlinx.coroutines.*

class CoroutinesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.coroutineScope.launch {

        }

        viewLifecycleOwner.lifecycleScope.launch {

        }

        // using async then using await keyword for wait the result
        GlobalScope.launch(Dispatchers.Main) {
            val firstStudent = async(Dispatchers.IO) { fetchStudent() }
            val secondStudent = async(Dispatchers.IO) { fetchStudent() }
            displayAllUser(firstStudent.await(), secondStudent.await())
        }
        GlobalScope.launch {  }

        // using withContext you cannot use await keyword
        GlobalScope.launch(Dispatchers.Main) {
            val firstStudent = withContext(Dispatchers.IO) { fetchStudent() }
            val secondStudent = withContext(Dispatchers.IO) { fetchStudent() }
            displayAllUser(firstStudent, secondStudent)
        }

    }

    private fun fetchStudent(): StudentModel {
        // TODO something here and return the result
        return fetchStudent()

    }

    private fun displayAllUser(firstStudentModel: StudentModel, secondStudent: StudentModel) {

    }

}