package com.example.midexamtamar

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var retrofit: Retrofit

    private val loggingInterceptor = HttpLoggingInterceptor()

    fun init() {


        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)


        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()


        retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/tak862/Shualeduri/refs/heads/main/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getReqResService(): ResService {
        return retrofit.create(ResService::class.java)
    }
}
