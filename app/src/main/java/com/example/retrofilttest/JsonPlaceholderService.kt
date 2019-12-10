package com.example.retrofilttest

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderService {
    @GET("/posts")
    fun posts(): Call<List<PostResp>>
}