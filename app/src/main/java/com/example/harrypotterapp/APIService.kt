package com.example.harrypotterapp

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("characters")
    fun getCharacter():Call<List<character>>
}