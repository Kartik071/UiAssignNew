package com.example.gcui.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gcui.R
import com.example.gcui.databinding.ActivityMainBinding
import com.example.gcui.model.MainModel
import com.example.gcui.model.Model
import com.example.gcui.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: DataViewModel
    var data: List<MainModel>? = null
    private var integerArrayList = ArrayList<Model>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[DataViewModel::class.java]
//        integerArrayList.add(Model(R.string.birthday_gift_to_your_loved_ones,R.drawable.images,R.string.birthdaygiftcard,R.string.load_your_gift_card_upto,R.string.loadyourgiftcardupto5000aed_1))
//        integerArrayList.add(Model(R.string.gift,R.drawable.images,R.string.gc,R.string.load_your_gift_card_upto,R.string.loadyourgiftcardupto5000aed_1))
//        val dataAdapter = RecyclerAdapter(integerArrayList)
        viewModel.fetchData()
//        errorModel()
        observerViewModel()
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


    }


    private fun observerViewModel() {
        viewModel.status.observe(this) { codeData ->
            if (codeData == 200) {
                Toast.makeText(this, "Data Received", Toast.LENGTH_SHORT).show()
                viewModel.data.observe(this) {
                    Log.d("Android", "observerViewModel: $it")
                    val data = it?.giftCardResponseList
                    setAdapter(data)
                }

            }
            else when (codeData) {
                500 -> Toast.makeText(this, "Token Error", Toast.LENGTH_SHORT).show()
            }
            when (codeData) {
                401 -> Toast.makeText(this, "Unauthorised", Toast.LENGTH_SHORT).show()
            }
            when (codeData) {
                400 -> Toast.makeText(this, "Bad Request", Toast.LENGTH_SHORT).show()
            }
            when(codeData){
                404-> Toast.makeText(this,"Url Not Found",Toast.LENGTH_SHORT).show()
            }



//            else if (codeData==401)
//                Toast.makeText(this,"UnAuthorised Access",Toast.LENGTH_SHORT).show()
//            else if (codeData==400)
//                Toast.makeText(this,"Bad Request",Toast.LENGTH_SHORT).show()
//
//            else
//                Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show()
            // RecyclerAdapter(it!!.giftCardResponseList,this)
            Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show()

        }
       }

    private fun setAdapter(data: ArrayList<MainModel.DataModel>?) {
        val dataAdapter = RecyclerAdapter(data, this)
        binding.recycler.adapter = dataAdapter
    }
}