package com.solve.retrofit

import com.solve.retrofit.model.AndroidClass
import com.solve.retrofit.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val api: Retrofit) {
    fun getClasses(adapter: AndroidAdapter) {
        val call: Call<List<AndroidClass>> = api.create(ApiInterface::class.java).getClasses()
        call.enqueue(object : Callback<List<AndroidClass>> {
            override fun onFailure(call: Call<List<AndroidClass>>?, t: Throwable?) {
                adapter.onFailure.invoke(t?.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<AndroidClass>>?,
                response: Response<List<AndroidClass>>?
            ) {
                response?.body().let{adapter.onResponse.invoke(it)}
            }

        })


    }
}