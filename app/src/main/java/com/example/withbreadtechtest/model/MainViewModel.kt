package com.example.withbreadtechtest.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.withbreadtechtest.api.WBRepository
import com.example.withbreadtechtest.data.WBResponse
import com.example.withbreadtechtest.data.WBVenue
import kotlinx.coroutines.*

class MainViewModel constructor(private val wBRepository: WBRepository) : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val venueList = MutableLiveData<List<WBVenue>>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllVenues() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = wBRepository.getAllVenues()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val wBResponse : WBResponse = response.body()!!
                    venueList.postValue(wBResponse.response.venues)
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }


}