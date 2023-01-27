package com.example.gcui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gcui.R
import com.example.gcui.databinding.ItemBinding
import com.example.gcui.model.MainModel

class RecyclerAdapter(private val dataList: ArrayList<MainModel.DataModel>?, var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder> (){
    private lateinit var binding: ItemBinding

    class ViewHolder(item : ItemBinding): RecyclerView.ViewHolder(item.root) {
        val userText: TextView = item.Header
        val imageView : ImageView =item.imageView
        val detail : TextView = item.detailText
        val load : TextView =item.amountTxt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context).load(dataList?.get(position)?.giftCardImageUrl).into(holder.imageView)
        holder.userText.text= dataList?.get(position)?.description
        holder.detail.text= dataList?.get(position)?.marketingContent01
        holder.load.text=dataList?.get(position)?.marketingContent02
//        holder.userText.setText(dataList[position].text)
//        holder.imageView.setImageResource(R.drawable.images)
//        holder.detail.setText(dataList[position].detail)
//        holder.load.setText(dataList[position].load)
//        holder.amount.setText(dataList[position].amount)

    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }
}
