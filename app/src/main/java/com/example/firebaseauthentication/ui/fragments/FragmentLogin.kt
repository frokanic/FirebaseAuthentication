package com.example.firebaseauthentication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebaseauthentication.R
import com.example.firebaseauthentication.databinding.FragmentLoginBinding
import com.example.firebaseauthentication.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentLogin: Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val repository = Repository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginUser()
        toRegistrationScreen()
    }

    private fun loginUser() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etInputUsername.text.toString().lowercase().trim()
            val password = binding.etInputPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                repository.loginUser(email, password)
                findNavController().navigate(R.id.action_fragmentLogin_to_fragmentLoggedIn)
            }
        }
    }

    private fun toRegistrationScreen() {
        binding.tvCreateANewAccount.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegistration)
        }
    }

}