package com.example.dagger2impl.domain.useCase

import com.example.dagger2impl.data.model.DataModel
import com.example.dagger2impl.data.remote.Repository.ProductRepo
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class UseCase @Inject constructor(
    private val repo: ProductRepo
) {
    operator fun invoke(): Observable<Response<DataModel>> {
        return repo.getAllProducts()
    }
}