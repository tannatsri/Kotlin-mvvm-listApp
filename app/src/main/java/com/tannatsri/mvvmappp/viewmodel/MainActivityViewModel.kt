package com.tannatsri.mvvmappp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tannatsri.mvvmappp.data.SchoolData
import com.tannatsri.mvvmappp.data.SchoolModel
import com.tannatsri.mvvmappp.retrofit.RetroInstance
import com.tannatsri.mvvmappp.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {


    lateinit var liveDataList: MutableLiveData<SchoolData>

    init {
        liveDataList = MutableLiveData()

    }

    fun getLiveDataObserver(): MutableLiveData<SchoolData> {
        return liveDataList
    }


    fun makeApiCall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getCollegeList()
//        Log.d("tanishq", "asasasan")

            call.enqueue(object: Callback<SchoolData> {
                override fun onResponse(
                    call: Call<SchoolData>,
                    response: Response<SchoolData>
                ) {
//                    Log.d("tanishq", "tannnnn")
//                    Log.d("tanishq", response.body().toString())
                    liveDataList.postValue(response.body())
                }

                override fun onFailure(call: Call<SchoolData>, t: Throwable) {
                    Log.d("tanishq", t.toString())
                    liveDataList.postValue(null)

                }

            }
            )


    }
}

private fun <T> Call<T>.enqueue(callback: Callback<List<SchoolModel>>) {

}



