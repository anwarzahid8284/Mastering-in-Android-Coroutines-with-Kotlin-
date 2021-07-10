package com.example.kotlinecoroutines_jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoroutineViewModel:ViewModel (){
    init {
        viewModelScope.launch {  }
    }
}