package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsScreenBinding

class InstructionsScreenFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions_screen,
            container,
            false)

        binding.buttonGotIt.setOnClickListener { view->
            view.findNavController()
                .navigate(InstructionsScreenFragmentDirections
                    .actionInstructionsDestinationToShoeListDestination())
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.instruction)

        return binding.root

    }

}