package com.example.countrydata

import com.example.countrydata.model.Example
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/all")
    fun getPosts() : Call<List<Example>>
}