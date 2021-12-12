package com.rezapour.woocertask.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rezapour.woocertask.R
import com.rezapour.woocertask.databinding.FragmentMainBinding
import com.rezapour.woocertask.model.product.Product
import com.rezapour.woocertask.util.DataState
import com.rezapour.woocertask.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        viewModel.getProducts()
    }

    private fun setObserver() {
        viewModel.dataState.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success<List<Product>> -> {
                    Log.d("mainFragemtnTest","ssss:${dataState.data.get(0).name}")
                }
                is DataState.Error -> {
                    Log.d("mainFragemtnTest", "error:${dataState.message}")
                }
                is DataState.Loading -> {
                    Log.d("mainFragemtnTest","loding")
                }

            }
        }
    }
}