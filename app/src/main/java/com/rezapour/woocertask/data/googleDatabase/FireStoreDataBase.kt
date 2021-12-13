package com.rezapour.woocertask.data.googleDatabase

import android.util.Log
import android.view.LayoutInflater
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rezapour.woocertask.databinding.FragmentSplashBinding
import com.rezapour.woocertask.model.user.User
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class FireStoreDataBase @Inject constructor(private val db: FirebaseFirestore) {


    suspend fun saveUser(user: User) = callbackFlow<String> {

        Log.d("mainFragemtnTest", "Start")
        db.collection("users").document("user")
            .set(user)
            .addOnSuccessListener { documentReference ->
                trySend("done")
                Log.d("mainFragemtnTest", "DocumentSnapshot added with ID:")
            }
            .addOnFailureListener { e ->
                trySend("error")
                Log.w("mainFragemtnTest", "Error adding document", e)
            }
        awaitClose { cancel() }
    }


    suspend fun getUser()= callbackFlow<User> {
        val db = Firebase.firestore
        db.collection("users").document("user")
            .get()
            .addOnSuccessListener { result ->
                if (result.data!=null){
                }
                Log.d("mainFragemtnTest", "${result.data}")
            }
            .addOnFailureListener { exception ->
                Log.w("mainFragemtnTest", "Error getting documents.", exception)
            }
        awaitClose { cancel() }
    }


}