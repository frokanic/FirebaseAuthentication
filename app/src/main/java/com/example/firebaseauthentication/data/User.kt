package com.example.firebaseauthentication.data

import android.os.Parcelable
import java.io.Serializable

data class User(
    val username: String,
    val email: String,
    val password: String
): Serializable
