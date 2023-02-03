package com.example.dagger2impl.data.remote.Repository

import com.example.dagger2impl.data.model.DataModel
import com.example.dagger2impl.data.remote.Api.Endpoint
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val api: Endpoint
) : ProductRepo {
    override fun getAllProducts(): Observable<Response<DataModel>> {
        return api.getProducts()
    }


}