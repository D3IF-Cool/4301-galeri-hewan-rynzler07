package com.d3if4119.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if4119.galerihewan.Hewan
import com.d3if4119.galerihewan.R
import com.d3if4119.network.HewanApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val data = MutableLiveData<List<Hewan>>()
    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch {
            try {
                data.value = HewanApi.service.getHewan()
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
    fun getData(): LiveData<List<Hewan>> = data
}