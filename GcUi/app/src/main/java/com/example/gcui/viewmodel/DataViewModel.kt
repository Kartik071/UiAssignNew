package com.example.gcui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gcui.data.ApiInstance
import com.example.gcui.model.MainModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class DataViewModel : ViewModel() {
    var data = MutableLiveData<MainModel?>()
    var status= MutableLiveData<Int>()
    private val apiInstance = ApiInstance()

    fun fetchData(){

        apiInstance.getData(getHeaderMap())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Response<MainModel>>{
                override fun onSubscribe(d: Disposable?) {
                    Log.d("TAG", "onSubscribe: ")
                }

//                override fun onNext(dataList: MainModel?) {
//                    data.value=dataList
//                }

                override fun onError(e: Throwable?) {
                  e?.printStackTrace()
                }

                override fun onComplete() {
                    Log.d("Android", "onComplete: ")
                }

                override fun onNext(dataList: Response<MainModel>?) {
                    data.value=dataList?.body()
                    status.value=dataList?.code()

                }

            })
    }

    private fun getHeaderMap(): Map<String, String> {
        val headerMap = mutableMapOf<String, String>()
        headerMap["Authorization"] = "MWVKlVhqFS8E36DC/Mw3hg=="
        headerMap["AUTH_TOKEN"] ="MWVKlVhqFS8E36DC/Mw3hg=="
        headerMap["Language"] = "EN"
        headerMap["COUNTRY"] = "United Arab Emirates"
        headerMap["CITY"] = "Asab"
        headerMap["DEVICE_ID"] ="dRO6325HQhyMhPfqX_eswn"
        headerMap["deviceId"] = "dRO6325HQhyMhPfqX_eswn"
        headerMap["APP_VERSION"] = "1.0.52"
        headerMap["Content-Type"] = "application/json"
        return headerMap
    }

}