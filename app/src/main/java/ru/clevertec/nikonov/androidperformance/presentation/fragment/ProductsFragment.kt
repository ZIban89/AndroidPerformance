package ru.clevertec.nikonov.androidperformance.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.clevertec.nikonov.androidperformance.data.dto.Product
import ru.clevertec.nikonov.androidperformance.databinding.ProductsFragmentBinding
import ru.clevertec.nikonov.androidperformance.presentation.view.ItemView
import ru.clevertec.nikonov.androidperformance.presentation.vm.ProductsViewModel

internal class ProductsFragment : Fragment() {

    val viewModel: ProductsViewModel by viewModels()

    private var _binding: ProductsFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProductsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getProductsButton.setOnClickListener { viewModel.getProducts() }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.productsFlow.collectLatest {
                    binding.getProductsButton.isVisible = it.isEmpty()
                    binding.productsScrollView.isVisible = it.isNotEmpty()
                    populate(it)
                }
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun populate(products: List<Product>) {
        binding.itemsContainer.removeAllViews()
        products.forEach {
            binding.itemsContainer.addView(
                ItemView(requireContext()).apply { populate(it) }
            )
        }
    }
}