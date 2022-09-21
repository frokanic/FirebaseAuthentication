package com.example.firebaseauthentication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firebaseauthentication.R
import com.example.firebaseauthentication.databinding.FragmentLoggedInBinding
import com.example.firebaseauthentication.databinding.FragmentLoginBinding
import com.example.firebaseauthentication.databinding.FragmentRegistrationBinding
import com.example.firebaseauthentication.repository.Repository


class FragmentLoggedIn : Fragment(R.layout.fragment_logged_in) {

    private lateinit var binding: FragmentLoggedInBinding
    private val repository = Repository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoggedInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogout.setOnClickListener {
            repository.signOut()
            findNavController().navigate(R.id.action_fragmentLoggedIn_to_fragmentLogin)
        }
    }

}