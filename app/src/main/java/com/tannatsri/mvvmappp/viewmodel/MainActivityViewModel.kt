package com.tannatsri.mvvmappp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tannatsri.mvvmappp.data.*
import com.tannatsri.mvvmappp.retrofit.RetroInstance
import com.tannatsri.mvvmappp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {


    lateinit var liveDataList: MutableLiveData<OrderData>

    init {
        liveDataList = MutableLiveData()

    }

    fun getLiveDataObserver(): MutableLiveData<OrderData> {
        return liveDataList
    }


    fun makeApiCall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getOrderData()
//        Log.d("tanishq", "asasasan")

            call.enqueue(object: Callback<OrderData> {
                override fun onResponse(
                    call: Call<OrderData>,
                    response: Response<OrderData>
                ) {
//                    Log.d("tanishq", "tannnnn")
//                    Log.d("tanishq", response.body().toString())
                    liveDataList.postValue(response.body())
                }

                override fun onFailure(call: Call<OrderData>, t: Throwable) {
                    Log.d("tanishq", t.toString())
                    liveDataList.postValue(null)

                }

            }
            )


    }
    sealed class PayoutAdapterView {
        data class PayoutCard(val data: OrderDetails) : PayoutAdapterView ()
        data class PayoutStatus(val data: OrderStatus) : PayoutAdapterView ()
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<OrderData>) {

}



