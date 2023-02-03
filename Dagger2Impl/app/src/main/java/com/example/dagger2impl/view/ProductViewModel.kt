package com.example.dagger2impl.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger2impl.data.model.DataModel
import com.example.dagger2impl.domain.useCase.UseCase
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {
    private val prodList = MutableLiveData<DataModel>()

    fun getData() {
        useCase().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Response<DataModel>> {
                override fun onSubscribe(d: Disposable?) {
                    Log.i("Check", "onSub: ")
                }

                override fun onNext(t: Response<DataModel>?) {
                    Log.i("Check", "onNext: " + t?.body())
                }

                override fun onError(e: Throwable?) {
                    Log.i("Check", "onError: ")
                }

                override fun onComplete() {
                    Log.i("Check", "onComplete: ")
                }

            })
    }

}