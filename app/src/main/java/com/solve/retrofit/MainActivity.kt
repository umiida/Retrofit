package com.solve.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.solve.retrofit.model.AndroidClass
import com.solve.retrofit.retrofit.ApiClient
import com.solve.retrofit.retrofit.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), NetworkListener{


    private val adapter = AndroidAdapter()
    lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcvMain.adapter = adapter
        networkHelper = NetworkHelper(ApiClient.getClient())
        setData()
    }
    fun setData(){
        networkHelper.getClasses(this)
    }

    override fun getResponse(models: List<AndroidClass>) {
        adapter.models = models
    }

    override fun getFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
