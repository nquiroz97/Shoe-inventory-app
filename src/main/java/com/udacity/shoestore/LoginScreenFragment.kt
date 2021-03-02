package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding


class LoginScreenFragment : Fragment() {
    private lateinit var binding: FragmentLoginScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login_screen,
            container,
            false
        )

        binding.buttonSignIn.setOnClickListener { view ->
            view.findNavController()
                .navigate(LoginScreenFragmentDirections
                    .actionLoginDestinationToWelcomeDestination())
        }

        binding.buttonSignUp.setOnClickListener { view ->
            view.findNavController()
                .navigate(LoginScreenFragmentDirections
                    .actionLoginDestinationToWelcomeDestination())
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.login)

        return binding.root
    }

}