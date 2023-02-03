package com.example.dagger2impl.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dagger2impl.R
import com.example.dagger2impl.data.model.DataModel
import com.example.dagger2impl.databinding.RecyclerLayoutBinding

class Adapter(private val context: Context, private var productList: DataModel) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var binding: RecyclerLayoutBinding

    inner class ViewHolder(recBinding: RecyclerLayoutBinding) :
        RecyclerView.ViewHolder(recBinding.root) {
        val image = recBinding.imageView
        val id = recBinding.idTextView
        val title = recBinding.titleTxtView
        val description = recBinding.descriptionTextView
        val category = recBinding.textViewCategory
        val price = recBinding.priceTxtView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_layout,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(productList[position].image).into(holder.image)
        holder.id.text = productList[position].id.toString()
        holder.title.text = productList[position].title
        holder.description.text = productList[position].description
        holder.category.text = productList[position].category
        holder.price.text = productList[position].price.toString()


    }

    override fun getItemCount(): Int {
        return productList.size
    }
}