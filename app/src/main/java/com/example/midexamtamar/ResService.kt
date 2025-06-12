package com.example.midexamtamar
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface ResService {
    @GET("Movie")
    fun getCities(@Query("page") page: Int): Call<ReqresObj<List<Model>>>
}