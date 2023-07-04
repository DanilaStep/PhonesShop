package com.example.product_details.ui.product_details

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.widget.FrameLayout.LayoutParams
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.core.view.setMargins
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.core.models.ScreenStateEnum.*
import com.example.product_details.R
import com.example.product_details.databinding.FragmentProductDetailBinding
import com.example.product_details.ui.adapters.CarouselAdapter
import kotlinx.coroutines.launch

class ProductDetailsFragment : BaseFragment<FragmentProductDetailBinding, ProductDetailsViewModel>(
    FragmentProductDetailBinding::inflate,
    ProductDetailsViewModel::class
) {
    private val adapterCarousel = CarouselAdapter()


    override fun initialize() {
        binding.crvModel.adapter = adapterCarousel

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.productDetailsStateFlow.collect() { data ->
                data?.let {
                    initCarousel(it.images)
                }

            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.productDetailsStateFlow.collect() { data ->
                data?.let {
                    initColorsRadioGroup(it.color)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.productDetailsStateFlow.collect() { data ->
                data?.let {
                    initSaveRadioButton(it.capacity)
                }
            }
        }
        showBack()
        onClickBasket()
        initTabs()

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
            viewModel.getAllProductDetails()
        }
    }

    fun initTabs() {
        binding.tvShop.setOnClickListener {
            binding.vShop.isVisible = true
            binding.vFeatures.isVisible = false
            binding.vDetails.isVisible = false
        }
        binding.tvDetails.setOnClickListener {
            binding.vDetails.isVisible = true
            binding.vShop.isVisible = false
            binding.vFeatures.isVisible = false
        }
        binding.tvFeatures.setOnClickListener {
            binding.vDetails.isVisible = false
            binding.vShop.isVisible = false
            binding.vFeatures.isVisible = true
        }
    }

    fun initCarousel(image: List<String>) {
        image.forEach { _ -> binding.crvModel.getCarouselLayoutManager() }
        adapterCarousel.submitList(image)
        binding.crvModel.apply {
            set3DItem(true)
            setAlpha(true)
            setInfinite(true)
            setFlat(true)
            setIsScrollingEnabled(true)
        }
    }


    fun initColorsRadioGroup(colors: List<String>) {
        colors.forEach { binding.rgColor.addView(createColorRadioButton(it)) }
    }

    private fun createColorRadioButton(color: String): AppCompatRadioButton {
        val destiny = resources.displayMetrics.density
        val radioButton = AppCompatRadioButton(requireContext())

        val lp = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        lp.width = (40 * destiny).toInt()
        lp.height = (40 * destiny).toInt()
        lp.setMargins((9 * destiny).toInt())

        radioButton.layoutParams = lp

        radioButton.background = createBackgroundRadioButton(Color.parseColor(color))
        radioButton.setButtonDrawable(R.drawable.bg_check_color)
        return radioButton
    }

    private fun createBackgroundRadioButton(parseColor: Int): Drawable? {
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.bg_color_blue)
        drawable?.setTint(parseColor)
        return drawable
    }

    fun initSaveRadioButton(capacity: List<String>) {
        capacity.forEach { binding.rgSave.addView(createSaveRadioButton(it)) }
    }

    private fun createSaveRadioButton(capacity: String): AppCompatRadioButton {
        val destiny = resources.displayMetrics.density
        val radioButton = AppCompatRadioButton(requireContext())

        val lp = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        lp.width = (70 * destiny).toInt()
        lp.height = (30 * destiny).toInt()
        lp.setMargins((7 * destiny).toInt())
        lp.gravity = (7 * destiny).toInt()


        radioButton.layoutParams = lp
        radioButton.textSize = 13F
        radioButton.text = " $capacity gb"
        radioButton.setButtonDrawable(R.color.white)
        radioButton.gravity = Gravity.CENTER
        radioButton.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.bg_save_check_background)
        radioButton.setTextColor(context?.let {
            ContextCompat.getColorStateList(it, R.color.radio_button_text_colors)
        })
        radioButton.setTextColor(
            ResourcesCompat.getColorStateList(
                resources,
                R.color.radio_button_text_colors,
                requireContext().theme
            )
        )

        return radioButton
    }

    fun showBack() {
        binding.ivClose.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    fun onClickBasket() {
        binding.cvBasket.setOnClickListener {
            findNavController().navigate(R.id.action_productDetailsFragment_to_myCartFragment)
        }
    }

    override fun showProgress() {
        binding.tStatus.showProgress()

    }

    override fun showContent() {
        binding.tStatus.showContent()
    }


}
