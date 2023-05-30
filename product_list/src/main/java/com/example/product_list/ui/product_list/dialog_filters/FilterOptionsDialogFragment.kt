package com.example.product_list.ui.product_list.dialog_filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.product_list.R
import com.example.product_list.databinding.FilterOptionsBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterOptionsDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FilterOptionsBottomSheetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FilterOptionsBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.FilterBottomSheetDialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setCanceledOnTouchOutside(false)

        setFilterDialog()
        binding.ivClose.setOnClickListener{
            dismiss()
        }
        binding.tvBuyNow.setOnClickListener{
            dismiss()
        }
    }

    private fun setFilterDialog() {
        dialog?.window?.attributes?.apply {
            width = ViewGroup.LayoutParams.MATCH_PARENT
            dialog?.window?.attributes = this
        }
    }
}