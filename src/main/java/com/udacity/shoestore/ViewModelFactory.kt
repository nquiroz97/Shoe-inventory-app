package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe

// Note: create custom ViewModel(s)
class ViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        // TODO: return correct ViewModel(s)

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}