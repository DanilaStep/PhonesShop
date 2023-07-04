package com.example.mycart.ui.my_cart

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.mycart.databinding.FragmentMyCartBinding
import com.example.mycart.domen.model.MyCartModel
import com.example.mycart.ui.adapter.MyCartAdapter
import kotlinx.coroutines.launch

class MyCartFragment : BaseFragment<FragmentMyCartBinding, MyCartViewModel>(
    FragmentMyCartBinding::inflate,
    MyCartViewModel::class
), MyCartAdapter.ClickListener {
    private val adapterMyCart = MyCartAdapter(this)
    override fun initialize() {
        binding.rvMyCart.adapter = adapterMyCart
        onClickDelete(id)
        showBack()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.myCartStateFlow.collect() { data ->
                data?.let {
                    fillData(it)

                }
            }

        }
    }

    private fun fillData(data: MyCartModel) {
        binding.tvTotalPrice.text = data.total.toString()
        binding.tvDeliveryFree.text = data.delivery
        adapterMyCart.submitList(data.basket)
    }

    fun showBack() {
        binding.ivClose.setOnClickListener {
            findNavController().popBackStack()
        }
    }


    override fun showPlaceholder() {

    }

    override fun showProgress() {

    }

    override fun showContent() {

    }

    override fun onClickDelete(id: Int) {
    }
}