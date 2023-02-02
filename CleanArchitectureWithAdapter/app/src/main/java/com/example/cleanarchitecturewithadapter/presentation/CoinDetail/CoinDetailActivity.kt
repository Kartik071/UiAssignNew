package com.example.cleanarchitecturewithadapter.presentation.CoinDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.cleanarchitecturewithadapter.R
import com.example.cleanarchitecturewithadapter.databinding.ActivityCoinDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinDetailActivity : AppCompatActivity() {
    private var valueRepeat = 3
    private var id: String = ""
    private lateinit var binding: ActivityCoinDetailBinding
    private var viewModel: CoinDetailViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coin_detail)
        viewModel = ViewModelProvider(this)[CoinDetailViewModel::class.java]

        if (intent != null) {
            val id = intent.getStringExtra("id")
            viewModel?.getCoinsById(id.toString())
            observeViewModel(id.toString())
        }
    }

    private fun observeViewModel(id: String) {
        CoroutineScope(Dispatchers.Main).launch {
            repeat(valueRepeat) {
                Log.d("id", "observeViewModel: $id")
                viewModel?.coinDetailValue?.collect { value ->
                    when {
                        value.isLoading -> {
                            binding.coinProgressBar.visibility = View.VISIBLE
                        }
                        value.error.isNotBlank() -> {
                            binding.coinProgressBar.visibility = View.GONE
                            valueRepeat = 0

                        }
                        value.coinDetail != null -> {
                            binding.coinProgressBar.visibility = View.GONE
                            valueRepeat = 0
                            Glide.with(this@CoinDetailActivity).load(value.coinDetail.image)
                                .into(binding.imgCoinDetail)
                            binding.txtCoinNameDetail.text = value.coinDetail.name
                            binding.txtCoinMarketCap.text = value.coinDetail.marketCap.toString()
                            binding.txtCoinPriceLow.text = value.coinDetail.lowPrice.toString()
                            binding.txtCoinPriceHigh.text = value.coinDetail.highPrice.toString()
                            binding.txtCoinPrice.text = value.coinDetail.price.toString()
                            binding.txtCoinPricePercentChange.text =
                                value.coinDetail.pricePercentageChange.toString()
                        }
                    }
                }

            }
        }
    }

}