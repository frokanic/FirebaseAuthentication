package com.example.firebaseauthentication.repository

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.example.firebaseauthentication.data.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await

class Repository {

    lateinit var response: MutableLiveData<String>
    private val auth = Firebase().getInstance()


    suspend fun registerUser(email: String, password: String) {
        response = MutableLiveData()
        try {
            auth.createUserWithEmailAndPassword(email, password).await()
            response.value = "Succeed"
        } catch (e: Exception) {
            response.value = e.message
        }
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    suspend fun loginUser(email: String, password: String) {
        response = MutableLiveData()
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            response.value = "Succeed"
        } catch (e: Exception) {
            response.value = e.message
        }
    }

    fun signOut() {
        auth.signOut()
    }


}