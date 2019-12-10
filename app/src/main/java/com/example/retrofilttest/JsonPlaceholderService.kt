package com.example.retrofilttest

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderService {
    @GET("/posts")
    fun posts(): Deferred<List<PostResp>>
}