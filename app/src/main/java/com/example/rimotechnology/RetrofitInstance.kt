package com.example.rimotechnology

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


const val BASE_URL = "http://52.15.82.204/api/v1/"
interface  RetrofitInterface{

    @POST("login")
   suspend fun PostLogin(@Body post : LoginData): Response<LoginData>
}


val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object RetrofitApi{
    val RetrofitService : RetrofitInterface by lazy {
        retrofit.create(RetrofitInterface::class.java)
    }
}