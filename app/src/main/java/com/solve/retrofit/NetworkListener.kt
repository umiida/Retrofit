package com.solve.retrofit

import com.solve.retrofit.model.AndroidClass
import retrofit2.Call

interface NetworkListener {
    fun getResponse(models: List<AndroidClass>)
    fun getFailure(message: String?)
}