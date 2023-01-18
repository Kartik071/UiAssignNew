package com.example.retrofitwithrx.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitwithrx.R
import com.example.retrofitwithrx.databinding.FragmentHomeBinding
import com.example.retrofitwithrx.viewModel.DataListViewModel


class HomeFragment : Fragment() {
    private lateinit var viewModel : DataListViewModel
    private lateinit var bindingFrag: FragmentHomeBinding
    private val dataAdapter = DataAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingFrag = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        viewModel=ViewModelProvider(this)[DataListViewModel::class.java]
        viewModel.fetchData()
        observeViewModel()
        bindingFrag.recyclerView.apply {
            layoutManager=LinearLayoutManager(activity)
            adapter=dataAdapter
        }
        return bindingFrag.root


    }
    private fun observeViewModel(){
        viewModel.data.observe(viewLifecycleOwner) {
            Log.d("Frag", "observeViewModel: $it")
            it?.let { it1 -> dataAdapter.updateList(it1) }
        }
    }


}