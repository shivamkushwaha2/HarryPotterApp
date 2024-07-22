package com.example.harrypotterapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private val baseurl = "https://potterapi-fedeperin.vercel.app/en/"

    val instance: APIService by lazy {
       Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build().create(APIService::class.java)
    }
}