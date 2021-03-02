package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListScreenBinding
import com.udacity.shoestore.models.Shoe

class ShoeListScreenFragment : Fragment() {
    private lateinit var binding: FragmentShoeListScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list_screen,
            container,
            false
        )
        // Note: let Android know a menu is associated with this Fragment
        setHasOptionsMenu(true)

        // Note: create ViewModel and associate to this Fragment
        //       also handles configuration changes such as device rotation
        val showDetailsViewModel = ViewModelProvider(requireActivity())
            .get(ShoeDetailsViewModel::class.java)

        // Note: setup binding for LiveData to know to observe this LifecycleOwner
        binding.lifecycleOwner = this

        // Note: ViewModel field(s) can now Observer Lifecycle changes
        showDetailsViewModel.shoes.observe(viewLifecycleOwner) { shoes ->
            if (shoes.isNotEmpty()) {
                createShoes(shoes)
            }
        }

        binding.floatingActionAdd.setOnClickListener { view ->
            view.findNavController()
                .navigate(
                    ShoeListScreenFragmentDirections
                        .actionShoeListDestinationToShoeDetailsDestination()
                )
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.list)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    // Note: leveraging NavigationUI library to handle menu navigation
    //       requires matching ids in menu and in navigation graph
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun createShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.listContainer
            shoes.forEach { shoe ->
                val shoeLayout = ShoeItem(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }
    }

}
