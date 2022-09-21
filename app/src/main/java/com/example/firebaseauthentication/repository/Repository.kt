package com.example.firebaseauthentication.repository

import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.firebaseauthentication.R
import com.example.firebaseauthentication.data.Firebase
import com.example.firebaseauthentication.data.User
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await

class Repository {

    lateinit var response: MutableLiveData<String>
    private val auth = Firebase().getInstance()

    fun registerUser(email: String, password: String) {
        response = MutableLiveData()
        try {
            auth.createUserWithEmailAndPassword(email, password)
            response.value = "Succeed"
        } catch (e: Exception) {
            response.value = e.message
        }
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun loginUser(email: String, password: String) {
        response = MutableLiveData()
        try {
            auth.signInWithEmailAndPassword(email, password)
           response.value = "Succeed"
        } catch (e: Exception) {
            response.value = e.message
        }
    }

    fun signOut() {
        auth.signOut()
    }

    fun userData(username: String) {

    }

    fun getCurrentUserId(): String {
        return auth.currentUser!!.uid
    }


}

//Get email and username from user -> Call function to check for uniqueness ->
// if both unique, call createUserWithEmailAndPassword and update username document.
// If either not unique, display error to the user.