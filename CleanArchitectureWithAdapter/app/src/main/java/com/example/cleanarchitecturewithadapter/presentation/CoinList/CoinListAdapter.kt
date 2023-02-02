package com.example.cleanarchitecturewithadapter.presentation.CoinList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarchitecturewithadapter.R
import com.example.cleanarchitecturewithadapter.databinding.RecyclerLayoutBinding
import com.example.cleanarchitecturewithadapter.domain.model.CoinList
import com.example.cleanarchitecturewithadapter.presentation.CoinDetail.CoinDetailActivity

class CoinListAdapter(private val context: Context, var coinList: ArrayList<CoinList>) :
    RecyclerView.Adapter<CoinListAdapter.ViewHolder>() {
    private lateinit var binding: RecyclerLayoutBinding

    inner class ViewHolder(recyclerLayoutBinding: RecyclerLayoutBinding) :
        RecyclerView.ViewHolder(recyclerLayoutBinding.root) {
        val coinLayout = recyclerLayoutBinding.coinLinearLayout
        val coinImage = recyclerLayoutBinding.imgCoinImage
        val coinName = recyclerLayoutBinding.txtCoinName

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("rec", "onCreateViewHolder: ")
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_layout,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    fun setData(list: ArrayList<CoinList>) {
        this.coinList = list
        notifyItemRangeChanged(0,coinList.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("rec", "onBindViewHolder: $coinList")
        holder.coinName.text = coinList[position].name
        Glide.with(context).load(coinList[position].image).into(holder.coinImage)
        holder.coinLayout.setOnClickListener {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra("id", coinList[position].id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

}