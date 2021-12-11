package com.rezapour.woocertask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rezapour.woocertask.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this, "1", Toast.LENGTH_LONG).show()
        val db = Firebase.firestore
        val user = hashMapOf(
            "name" to "mansour",
            "email" to "mansour@Gmail.com",
            "website" to "www.google.com"
        )

        db.collection("user").document("ss2")
            .set(user)
            .addOnSuccessListener { documentReference ->
                Log.d("mansourtest", "DocumentSnapshot added with ID:")
            }
            .addOnFailureListener { e ->
                Log.d("mansourtest", "Error adding document", e)
            }
    }
}