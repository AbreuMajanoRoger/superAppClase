package com.example.superapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("search/{name}")
    suspend fun getSuperHeroes(@Path("name")SuperHeroesName:String):Response<SuperHeroesData>
    @GET("{id}")
    suspend fun getSuperHeroesId(@Path("id") id:String): Response<SuperHeroesItemResponse>


}