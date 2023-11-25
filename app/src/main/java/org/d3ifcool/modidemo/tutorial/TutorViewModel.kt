package org.d3ifcool.modidemo.tutorial

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TutorViewModel : ViewModel() {
    private val data = MutableLiveData<List<TutorModel>>()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                requestData()
            }
        }
    }

    private suspend fun requestData() {
        viewModelScope.launch (Dispatchers.IO ){
            try {
                data.postValue(TutorApi.service.getTutor())
            }
            catch (e: Exception) {
                Log.d("REQUEST", e.message.toString())
            }
        }
    }

    fun getData(): LiveData<List<TutorModel>> = data
}