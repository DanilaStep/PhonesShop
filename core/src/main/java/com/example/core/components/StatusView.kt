package com.example.core.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.core.databinding.StatusViewBinding

class StatusView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : ConstraintLayout(context, attrs) {

    private val binding = StatusViewBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun showProgress() {
        binding.flBackground.isVisible = true
        binding.progressBar.isVisible = true
        binding.llPlaceHolder.isGone = true
    }

    fun showPlaceHolder(message: String = "Error", onClick: OnClickListener) {
        binding.flBackground.isVisible = true
        binding.llPlaceHolder.isVisible = true
        binding.progressBar.isGone = true
        binding.tvPlaceHolder.text = message
        binding.placeholderButton.setOnClickListener(onClick)
    }

    fun showContent() {
        binding.flBackground.isGone = true
    }
}