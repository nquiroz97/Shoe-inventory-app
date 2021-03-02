package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome_screen,
            container,
            false
        )

        binding.buttonStart.setOnClickListener { view ->
            view.findNavController().navigate(
                WelcomeScreenFragmentDirections
                    .actionWelcomeDestinationToInstructionsDestination()
            )
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.welcome_screen)

        return binding.root
    }

}