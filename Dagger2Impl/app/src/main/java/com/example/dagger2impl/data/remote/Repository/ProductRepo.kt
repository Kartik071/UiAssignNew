package com.example.dagger2impl.data.remote.Repository

import com.example.dagger2impl.data.model.DataModel
import io.reactivex.Observable
import retrofit2.Response

interface ProductRepo {

    fun getAllProducts() : Observable<Response<DataModel>>

}