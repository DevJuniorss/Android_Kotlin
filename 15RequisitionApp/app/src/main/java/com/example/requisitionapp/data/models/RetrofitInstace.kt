package com.example.requisitionapp.data.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstace {
    private const val BASE_URL = "https://my-api-0362.onrender.com/"

    val api:ApiServices by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices::class.java)
    }
}