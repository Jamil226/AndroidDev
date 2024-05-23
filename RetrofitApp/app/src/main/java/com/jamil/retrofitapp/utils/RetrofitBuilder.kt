package com.jamil.retrofitapp.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    // private val retrofit by lazy uses Kotlin's delegate
    // properties with lazy initialization
    // to create a retrofit property.
    //    Benefits -> Performance Optimization, Thread Safety

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiUrls.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:Api by lazy {
        retrofit.create(Api::class.java)
    }
}