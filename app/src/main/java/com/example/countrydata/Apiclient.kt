package com.example.countrydata
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient {
    companion object{
        var BASE_URL="https://restcountries.com/"
        private lateinit var retrofit: Retrofit

        fun getRetrofit(): Retrofit {

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit

        }
    }
}