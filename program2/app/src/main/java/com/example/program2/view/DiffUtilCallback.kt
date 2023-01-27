package com.example.program2.view

import androidx.recyclerview.widget.DiffUtil
import com.example.retrofitwithrx.model.DataModelItem

data class DiffUtilCallback(val dataList : ArrayList<DataModelItem>, val updatedList: List<DataModelItem>):DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return dataList.size
    }

    override fun getNewListSize(): Int {
       return updatedList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return dataList[oldItemPosition].id== updatedList[newItemPosition].id
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       val itemOld =dataList[oldItemPosition]
        val newItem =updatedList[newItemPosition]
        return itemOld.body== newItem.body
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)

    }
}
