package com.miu.student.walmart

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_item.view.*


class ProductsAdapter( var products:ArrayList<Product>) :RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    var onItemClick: ((Product) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var product = products.get(position)
        holder.bind(product)
    }
    override fun getItemCount(): Int {
        return products.size
    }
  inner  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.productTitle.text = product.Title
            itemView.productPrice.text = product.price.toString()
            itemView.productColor.text = product.color
            itemView.productImage.setImageResource(product.image)
            itemView.setOnClickListener {
                onItemClick?.invoke(product)
            }
        }
    }

    //get image bitmap from URL

}