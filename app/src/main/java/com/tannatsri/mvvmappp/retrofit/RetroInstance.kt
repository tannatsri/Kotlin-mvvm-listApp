package com.tannatsri.mvvmappp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {



    companion object {
//        https://run.mocky.io/v3/3d974103-c367-494c-8723-72c64a049cc4

        const val Base_Url = "https://run.mocky.io/v3/"
//        http://universities.hipolabs.com/search?country=india

        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}