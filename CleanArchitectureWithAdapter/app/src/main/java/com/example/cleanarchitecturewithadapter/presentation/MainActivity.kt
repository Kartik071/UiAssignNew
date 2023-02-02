package com.example.cleanarchitecturewithadapter.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cleanarchitecturewithadapter.R
import com.example.cleanarchitecturewithadapter.databinding.ActivityMainBinding
import com.example.cleanarchitecturewithadapter.domain.model.CoinList
import com.example.cleanarchitecturewithadapter.presentation.CoinList.CoinListAdapter
import com.example.cleanarchitecturewithadapter.presentation.CoinList.CoinListViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var valueRepeat = 3
    private val page = 1
    private lateinit var coinListViewModel: CoinListViewModel
    private lateinit var coinListAdapter: CoinListAdapter
    private val tempList = arrayListOf<CoinList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        coinListViewModel = ViewModelProvider(this)[CoinListViewModel::class.java]
        coinListViewModel.getAllCoins(page = page.toString())
        observeViewModel()
        binding.recyclerView.apply {
            coinListAdapter = CoinListAdapter(this@MainActivity, ArrayList())
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = coinListAdapter
        }

    }

    private fun observeViewModel() {
        CoroutineScope(Dispatchers.Main).launch {
            repeat(valueRepeat) {
                coinListViewModel.coinListValue.collect { value ->
                    Log.d("Android", "observeViewModel: $value")
                    when {
                        value.isLoading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        value.error.isNotBlank() -> {
                            binding.progressBar.visibility = View.VISIBLE
                            valueRepeat = 0
                            Snackbar.make(binding.root, value.error, Snackbar.LENGTH_LONG).show()

                        }
                        value.coinList.isNotEmpty() -> {
                            binding.progressBar.visibility = View.GONE
                            valueRepeat = 0
                            tempList.addAll(value.coinList)
                            coinListAdapter.setData(tempList)

                        }

                    }
                }
            }
        }
    }
}