package com.example.mytaskbeunique.network

import com.example.mytaskbeunique.adapter.imagemodel.DataX
import com.example.mytaskbeunique.model.DataY
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL =
    "https://api.zipconnect.app/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    //class MarsProperty : ArrayList<Any>().addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface InterestApiService {
    @Headers("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYwZGM1MThlODJlM2QwMDNjZTc4MmMzMiIsImlhdCI6MTYyODQzMDUwOCwiZXhwIjoxNjM2MjA2NTA4fQ.x24t3_fy4hKsBBzt4zPk1RvYMJtWUlKFfoUcqbS_Xtk")
    @GET("/")
    suspend fun getPhots():
            List<DataY>


    // testing purpose
    @GET("api/v1/category/")
    fun getPhotsX():
            Call<List<DataX>>
}

object InterestApi {
    val retrofitService: InterestApiService by lazy {
        retrofit.create(InterestApiService::class.java)
    }
}
