package com.example.retrofilttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private val mUrl = "https://jsonplaceholder.typicode.com/posts/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrolfit = Retrofit.Builder().baseUrl(mUrl).addConverterFactory(GsonConverterFactory.create()).build()
        val api = retrolfit.create(JsonPlaceholderService::class.java)

        api.posts().enqueue(object : Callback<List<PostResp>>{
            override fun onFailure(call: Call<List<PostResp>>, t: Throwable) {
                Log.d(TAG, "TTT onFailure")
            }

            override fun onResponse(
                call: Call<List<PostResp>>,
                response: Response<List<PostResp>>
            ) {
                printItem(response.body())
            }
        })

    }

    fun printItem(list: List<PostResp>?) {
        list?.forEach {
            Log.d(TAG, "TTT id = {${it.id}}, ${it.userId}, ${it.title}")
        }
    }
}
