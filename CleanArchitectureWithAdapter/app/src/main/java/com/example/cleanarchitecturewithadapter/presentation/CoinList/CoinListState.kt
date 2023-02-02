package com.example.cleanarchitecturewithadapter.presentation.CoinList

import com.example.cleanarchitecturewithadapter.domain.model.CoinList

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<CoinList> = emptyList(),
    val error: String = ""
)
