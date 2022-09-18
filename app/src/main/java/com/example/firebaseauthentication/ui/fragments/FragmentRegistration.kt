package com.example.firebaseauthentication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebaseauthentication.R
import com.example.firebaseauthentication.databinding.FragmentRegistrationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentRegistration : Fragment(R.layout.fragment_registration) {

    private lateinit var binding: FragmentRegistrationBinding

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
            val username = binding.etInputUsername.text.toString()
            val email = binding.etInputEmail.text.toString()
            val password = binding.etInputPassword.text.toString()
            val confirmPassword = binding.etInputConfirmPassword.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {

            }
        }
    }

    private fun toLoginScreen() {
        binding.tvAlreadyHaveAnAccount.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRegistration_to_fragmentLogin)
        }
    }



}