package com.rezapour.woocertask.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rezapour.woocertask.R
import com.rezapour.woocertask.databinding.FragmentMainBinding
import com.rezapour.woocertask.model.product.Product
import com.rezapour.woocertask.ui.adapter.ProductRecyclerviewAdapter
import com.rezapour.woocertask.util.DataState
import com.rezapour.woocertask.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    val binding get() = _binding!!
    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: ProductRecyclerviewAdapter
    private lateinit var progressBar: ProgressBar

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
        initUi()
        setObserver()
        viewModel.getProducts()
    }


    private fun initUi() {
        progressBar = binding.progressBar
        val product = ArrayList<Product>()
        recyclerview = binding.recyclerProductList
        adapter = ProductRecyclerviewAdapter(product)
        recyclerview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = adapter
    }

    private fun setObserver() {
        viewModel.dataState.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success<List<Product>> -> {
                    showProgressBar(false)
                    adapter.productList = dataState.data
                    adapter.notifyDataSetChanged()
                }
                is DataState.Error -> {
                    showProgressBar(false)
                    Toast.makeText(context, dataState.message, Toast.LENGTH_LONG).show()
                }
                is DataState.Loading -> {
                    showProgressBar(true)
                }

            }
        }
    }


    private fun showProgressBar(isShowing: Boolean) {
        if (isShowing)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.INVISIBLE
    }


}