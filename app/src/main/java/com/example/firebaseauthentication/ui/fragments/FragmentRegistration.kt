package com.example.firebaseauthentication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.firebaseauthentication.R
import com.example.firebaseauthentication.data.User
import com.example.firebaseauthentication.databinding.FragmentRegistrationBinding
import com.example.firebaseauthentication.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentRegistration : Fragment(R.layout.fragment_registration) {

    private lateinit var binding: FragmentRegistrationBinding
    private val repository = Repository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerUser()
        toLoginScreen()
    }



    private fun registerUser() {
        binding.btnRegister.setOnClickListener {
            val username = binding.etInputUsername.text.toString().trim()
            val email = binding.etInputEmail.text.toString().lowercase().trim()
            val password = binding.etInputPassword.text.toString().trim()
            val confirmPassword = binding.etInputConfirmPassword.text.toString().trim()
            val passwordsMatch = ( password == confirmPassword )

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (passwordsMatch) {
                    repository.registerUser(email, password)
                    findNavController().navigate(R.id.action_fragmentRegistration_to_fragmentLogin)
                } else {
                    //Toast.makeText(this@FragmentRegistration, "Password fields should match", Toast.LENGTH_SHORT)
                }
            }
        }
    }

    private fun toLoginScreen() {
        binding.tvAlreadyHaveAnAccount.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRegistration_to_fragmentLogin)
        }
    }



}