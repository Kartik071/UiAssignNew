package com.example.cleanarchitecturewithadapter.presentation.CoinDetail

import com.example.cleanarchitecturewithadapter.domain.model.CoinDetail

class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail?=null,
    val error: String = ""
)