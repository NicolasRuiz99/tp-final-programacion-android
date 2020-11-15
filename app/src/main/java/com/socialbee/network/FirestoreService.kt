package com.socialbee.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.socialbee.model.Producer

const val PRODUCERS_COLLECTION_NAME = "producers"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val setting = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init{
        firebaseFirestore.firestoreSettings = setting
    }

    fun getProducer (callback: Callback <List <Producer>>){
        firebaseFirestore.collection(PRODUCERS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Producer::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}