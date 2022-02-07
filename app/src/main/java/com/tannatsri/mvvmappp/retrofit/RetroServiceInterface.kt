package com.tannatsri.mvvmappp.retrofit

import com.tannatsri.mvvmappp.data.OrderData
import com.tannatsri.mvvmappp.data.SchoolData
import com.tannatsri.mvvmappp.data.SchoolModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

//    @GET("search")
//    fun getCollegeList(): Call<List<SchoolModel>> (@Query("country") String countryName);
//    https://run.mocky.io/v3/e25bd7da-e83d-417e-a050-c32a1f6eabb8
    @GET("3d974103-c367-494c-8723-72c64a049cc4")
    fun getCollegeList(
//        @Query("country") countryName:String

    ): Call<SchoolData>

    @GET("5f1c6215-0469-4e19-a13f-6b23fc151490")
    fun getOrderData(): Call<OrderData>




}