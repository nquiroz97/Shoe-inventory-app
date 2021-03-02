package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeDetailsFragment : Fragment() {
    private lateinit var shoeDetailsViewModel: ShoeDetailsViewModel
    private lateinit var binding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        Timber.i("Fragment Lifecycle onCreateView: inflate view and handle bindings.")

        binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater, R.layout.fragment_shoe_details, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.i(
            "Fragment Lifecycle onViewCreated: " +
                    "Fragment View has been instantiated so handle LifecycleOwner "
        )

        // Note: create ViewModel and associate to this Fragment
        //       also handles configuration changes such as device rotation
        shoeDetailsViewModel = ViewModelProvider(requireActivity())
            .get(ShoeDetailsViewModel::class.java)

        // Note: setup binding for LiveData to know to observe this LifecycleOwner
        binding.lifecycleOwner = this

        binding.shoe = Shoe("", "", "", "")

        binding.btnSave.setOnClickListener { view ->
            val shoe = binding.shoe

            shoeDetailsViewModel.saveCurrentDetail(shoe)

            // Note: leverage Navigation via graph to find correct destination to
            //       popTo: shoe_list (non-inclusive)
            view?.findNavController()
                ?.navigate(ShoeDetailsFragmentDirections
                    .actionShoeDetailsDestinationToShoeListDestination())
        }

        // Note: leverage Navigation via graph to find correct destination to
        //       popTo: shoe_list (non-inclusive)
        binding.btnCancel.setOnClickListener { view ->
            view?.findNavController()
                ?.navigate(ShoeDetailsFragmentDirections
                    .actionShoeDetailsDestinationToShoeListDestination())
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_details)
    }

}