package com.example.firebaseauthentication.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class Firebase {

    fun getInstance(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    fun getDbInstance(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    fun getFirebaseFirestoreInstance(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

}