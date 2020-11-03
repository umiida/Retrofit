package com.solve.retrofit.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        private lateinit var retrofit: Retrofit
        private lateinit var gson: Gson

        fun getClient(): Retrofit{
            if(!::gson.isInitialized){
                gson = GsonBuilder().setLenient().create()
            }
            if(!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl("http://api.texnopos.uz/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
    }

}