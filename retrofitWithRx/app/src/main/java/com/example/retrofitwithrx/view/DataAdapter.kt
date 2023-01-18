package com.example.retrofitwithrx.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithrx.R
import com.example.retrofitwithrx.databinding.DataItemBinding
import com.example.retrofitwithrx.model.DataModelItem

class DataAdapter(private val dataList: ArrayList<DataModelItem>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    lateinit var binding: DataItemBinding

    class ViewHolder(itemBind: DataItemBinding) : RecyclerView.ViewHolder(itemBind.root) {
        val idTxt: TextView = itemBind.id
        val userIdTxt: TextView = itemBind.userId
        val body: TextView = itemBind.body
        val titleTxt: TextView = itemBind.title


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.data_item,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idTxt.text = dataList[position].id.toString()
        holder.userIdTxt.text = dataList[position].userId.toString()
        holder.titleTxt.text = dataList[position].title
        holder.body.text = dataList[position].body

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun updateList(updateList: List<DataModelItem>){
        val diffUtilCallback = DiffUtilCallback(this.dataList,updateList)
        val diffResult : DiffResult=DiffUtil.calculateDiff(diffUtilCallback)
        dataList.addAll(updateList)
        diffResult.dispatchUpdatesTo(this)

    }
}