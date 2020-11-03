package com.solve.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.solve.retrofit.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val adapter = AndroidAdapter()
    private lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.onResponse {
            adapter.models = it
        }

        adapter.onFailure {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        rcvMain.adapter = adapter
        networkHelper = NetworkHelper(ApiClient.getClient())
        setData()
    }

    private fun setData() {
        networkHelper.getClasses(adapter)
    }

}
