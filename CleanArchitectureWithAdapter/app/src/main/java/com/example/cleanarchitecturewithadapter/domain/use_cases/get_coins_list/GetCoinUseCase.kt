package com.example.cleanarchitecturewithadapter.domain.use_cases.get_coins_list

import com.example.cleanarchitecturewithadapter.domain.model.CoinList
import com.example.cleanarchitecturewithadapter.domain.repository.CoinRepository
import com.example.cleanarchitecturewithadapter.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(page: String): Flow<Response<List<CoinList>>> = flow {
        try {
            emit(Response.Loading<List<CoinList>>())
            val coinList = repository.getAllCoins(page = page).map {
                it.toCoinList()
            }
            emit(Response.Success<List<CoinList>>(coinList))


        } catch (e: HttpException) {
            emit(Response.Error<List<CoinList>>(e.localizedMessage ?: "Unexpected Error Occurred"))

        } catch (e: IOException) {
            emit(Response.Error<List<CoinList>>("Error Occurred"))
        }
    }
}