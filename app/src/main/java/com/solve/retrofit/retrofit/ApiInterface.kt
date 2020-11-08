package com.solve.retrofit.retrofit

import com.solve.retrofit.model.AndroidClass
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/class?type=class")
    fun getClasses(): Call<List<AndroidClass>>
}