package com.example.cleanarchitecturewithadapter.domain.use_cases.get_detail_data

import com.example.cleanarchitecturewithadapter.domain.model.CoinDetail
import com.example.cleanarchitecturewithadapter.domain.model.CoinList
import com.example.cleanarchitecturewithadapter.domain.repository.CoinRepository
import com.example.cleanarchitecturewithadapter.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject
constructor(private val repository: CoinRepository) {
    operator fun invoke(id: String): Flow<Response<CoinDetail>> = flow{
        try {
            emit(Response.Loading<CoinDetail>())
            val coinDetail = repository.getCoinsById(id).toCoinDetail()
            emit(Response.Success<CoinDetail>(coinDetail))


        } catch (e: HttpException) {
            emit(Response.Error<CoinDetail>(e.localizedMessage ?: "Unexpected Error Occurred"))

        } catch (e: IOException) {
            emit(Response.Error<CoinDetail>("Error Occurred"))
        }

    }

}