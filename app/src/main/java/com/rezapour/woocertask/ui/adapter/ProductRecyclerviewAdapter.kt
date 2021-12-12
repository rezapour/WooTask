package com.rezapour.woocertask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rezapour.woocertask.databinding.ProductRowBinding
import com.rezapour.woocertask.model.product.Product

class ProductRecyclerviewAdapter(var productList: List<Product>) :
    RecyclerView.Adapter<ProductRecyclerviewAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ProductRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(product: Product) {
            binding.tvProductName.text = product.name
            binding.tvProductPrice.text = "${product.price}$"
            binding.tvProductStatus.text = product.status
            Glide.with(itemView.context).load(product.imagesUrl)
                .into(binding.ivProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList.get(position)
        holder.bindItem(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }


}