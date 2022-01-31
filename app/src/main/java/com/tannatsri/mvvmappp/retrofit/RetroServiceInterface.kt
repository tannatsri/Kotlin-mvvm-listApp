package com.tannatsri.mvvmappp.retrofit

import com.tannatsri.mvvmappp.data.SchoolData
import com.tannatsri.mvvmappp.data.SchoolModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

//    @GET("search")
//    fun getCollegeList(): Call<List<SchoolModel>> (@Query("country") String countryName);

    @GET("3d974103-c367-494c-8723-72c64a049cc4")
    fun getCollegeList(
//        @Query("country") countryName:String

    ): Call<SchoolData>



}