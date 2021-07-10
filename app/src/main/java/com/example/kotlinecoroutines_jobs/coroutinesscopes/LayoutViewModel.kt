package com.example.kotlinecoroutines_jobs.coroutinesscopes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LayoutViewModel:ViewModel() {
    fun viewModelCoroutines(){
        viewModelScope.launch {
            // this coroutines will be cancelled when viewModel is cleared
        }
    }
}