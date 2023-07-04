package com.example.product_list.ui.product_list

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.core.models.ScreenStateEnum.*
import com.example.product_list.R
import com.example.product_list.databinding.FragmentProductListBinding
import com.example.product_list.ui.adapters.BestSellerAdapter
import com.example.product_list.ui.adapters.HotSaleAdapter
import com.example.product_list.ui.product_list.dialog_filters.FilterOptionsDialogFragment
import kotlinx.coroutines.launch

class ProductListFragment : BaseFragment<FragmentProductListBinding, ProductListViewModel>(
    FragmentProductListBinding::inflate,
    ProductListViewModel::class
), BestSellerAdapter.ClickListener, HotSaleAdapter.ClickListener {
    private val adapterBestSeller = BestSellerAdapter(this)
    private val adapterHotSaleAdapter = HotSaleAdapter(this)


    override fun initialize() {
        binding.rvHotSale.adapter = adapterHotSaleAdapter
        binding.rvBestSeller.adapter = adapterBestSeller
        onClickFunnel()
        onClickBasket()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.productsStatFlow.collect() { data ->
                data?.let {
                    adapterHotSaleAdapter.submitList(it.homeStore)
                    adapterBestSeller.submitList(it.bestSeller)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.screenStateFlow.collect() {
                when (it) {
                    PROGRESS -> showProgress()
                    ERROR -> showPlaceholder()
                    SUCCESS -> showContent()
                }
            }
        }
    }

    override fun showPlaceholder() {
        binding.tStatus.showPlaceHolder {
            viewModel.getAllProducts()
        }
    }

    override fun showProgress() {
        binding.tStatus.showProgress()
    }

    override fun showContent() {
        binding.tStatus.showContent()
    }

    override fun onClickBestSeller(id: Int) {
        findNavController().navigate(R.id.action_productListFragment_to_productDetailsFragment)
    }

    override fun onClickLike(id: Int) {
    }

    private fun onClickFunnel() {
        binding.funnel.setOnClickListener {
            FilterOptionsDialogFragment().show(requireActivity().supportFragmentManager, null)
        }
    }

    override fun onClickHomeStore(id: Int) {
        findNavController().navigate(R.id.action_productListFragment_to_productDetailsFragment)
    }

    fun onClickBasket() {
        binding.ivBasket.setOnClickListener {
            findNavController().navigate(R.id.action_productListFragment_to_myCartFragment)
        }
    }
}