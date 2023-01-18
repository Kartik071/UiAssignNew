package com.example.retrofitwithrx.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitwithrx.data.ApiInstance
import com.example.retrofitwithrx.model.DataModelItem
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DataListViewModel : ViewModel(){
    var data = MutableLiveData<List<DataModelItem>?>()
    private val apiInstance = ApiInstance()

    fun fetchData() {

        apiInstance.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<DataModelItem>> {
                override fun onSubscribe(d: Disposable?) {
                    Log.d("OnSubscribe", "onSubscribe: ")
                }

                override fun onNext(dataList: List<DataModelItem>?) {
                    data.value = dataList

                }

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                }

                override fun onComplete() {
                    Log.d("Android", "onComplete: ")
                }


            })
    }

}