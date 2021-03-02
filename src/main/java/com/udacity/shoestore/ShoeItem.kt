package com.udacity.shoestore

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeItem : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding: ShoeListItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context), R.layout.shoe_list_item, this, false
    )

    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoeName.text = shoe.name
            shoeCompany.text = shoe.company
            shoeSize.text = shoe.size.toString()
            shoeDescription.text = shoe.description
        }
    }
}