package com.example.product_details.ui.product_details
import com.example.core.base.BaseFragment
import com.example.product_details.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding, ProductDetailsViewModel>(
    FragmentProductDetailsBinding::inflate,
    ProductDetailsViewModel::class
) {

    override fun initialize() {
    }

    override fun showPlaceholder() {

    }

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }

}