package com.example.superapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/2a6069d82438c4aa43d0ee6399a75194/search/{name}")
    suspend fun getSuperHeroes(@Path("name")SuperHeroesName:String):Response<SuperHeroesData>
    @GET("/api/2a6069d82438c4aa43d0ee6399a75194/{id}")
    suspend fun getSuperHeroesId(@Path("id") id:String): Response<SuperHeroDetail>

}