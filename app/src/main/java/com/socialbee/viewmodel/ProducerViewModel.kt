package com.socialbee.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.socialbee.model.Producer
import com.socialbee.network.Callback
import com.socialbee.network.FirestoreService

class ProducerViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    val listProducers: MutableLiveData<List<Producer>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getProducerFromFirebase()
    }

    fun getProducerFromFirebase () {
        firestoreService.getProducer(object : Callback<List<Producer>> {
            override fun onSuccess(result: List<Producer>?) {
                listProducers.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {

            }
        })
    }

    fun processFinished(){
        isLoading.value = true
    }
}