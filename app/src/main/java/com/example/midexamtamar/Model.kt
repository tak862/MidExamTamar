package com.example.midexamtamar

import com.google.gson.annotations.SerializedName

data class Model (
    val id: Int,
    val name: String,
    val description:String,
    val releaseData: Int,
    val time: Float,
    val country:String,
    val  imageUrl :String,

)
data class ReqresObj<T>(
    var page: Int?,
    @SerializedName("per_page")
    var perPage: Int?,
    var total: Long?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    var data: T?
)