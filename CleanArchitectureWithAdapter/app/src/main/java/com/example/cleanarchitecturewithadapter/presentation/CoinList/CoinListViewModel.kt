package com.example.cleanarchitecturewithadapter.presentation.CoinList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturewithadapter.domain.use_cases.get_coins_list.GetCoinUseCase
import com.example.cleanarchitecturewithadapter.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase
) : ViewModel() {
    private val _coinListValue = MutableStateFlow(CoinListState())
    var coinListValue: StateFlow<CoinListState> = _coinListValue

   fun getAllCoins(page: String)= viewModelScope.launch(Dispatchers.IO){

       getCoinUseCase(page).collect{
           when(it){
               is Response.Success ->{
                _coinListValue.value= CoinListState(coinList = it.data?: emptyList())
               }
               is Response.Loading ->{
            _coinListValue.value=CoinListState(isLoading = true)
               }
               is Response.Error ->{
                _coinListValue.value=CoinListState(error = it.message?:"An unexpected Error")
               }
           }
       }
   }


}