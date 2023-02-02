package com.example.cleanarchitecturewithadapter.presentation.CoinDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturewithadapter.domain.use_cases.get_detail_data.GetCoinDetailUseCase
import com.example.cleanarchitecturewithadapter.presentation.CoinList.CoinListState
import com.example.cleanarchitecturewithadapter.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinDetailUseCase: GetCoinDetailUseCase
): ViewModel() {
    private val _coinDetailValue = MutableStateFlow(CoinDetailState())
    var coinDetailValue: StateFlow<CoinDetailState> = _coinDetailValue

    fun getCoinsById(id: String)= viewModelScope.launch(Dispatchers.IO){

        coinDetailUseCase(id).collect{
            when(it){
                is Response.Success ->{
                    _coinDetailValue.value= CoinDetailState(coinDetail = it.data)
                }
                is Response.Loading ->{
                    _coinDetailValue.value= CoinDetailState(isLoading = true)
                }
                is Response.Error ->{
                    _coinDetailValue.value= CoinDetailState(error = it.message?:"An unexpected Error")
                }
            }
        }
    }

}