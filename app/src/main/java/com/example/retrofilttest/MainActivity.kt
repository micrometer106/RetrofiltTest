package com.example.retrofilttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

        val retrolfit = Retrofit.Builder()
            .baseUrl(mUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        val api = retrolfit.create(JsonPlaceholderService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val result = api.posts().await()
            printItem(result)
            showFagment(result)
        }

    }

    fun showFagment(list : List<PostResp>) {
        var mainFragment = MainFragment(list)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, mainFragment, "main_frag").commit()
    }

    fun printItem(list: List<PostResp>?) {
        list?.forEach {
            Log.d(TAG, "TTT id = {${it.id}}, ${it.userId}, ${it.title}")
        }
    }
}
