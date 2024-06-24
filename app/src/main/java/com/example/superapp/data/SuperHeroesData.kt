package com.example.superapp.data

import com.google.gson.annotations.SerializedName

data class SuperHeroesData(
    @SerializedName("response")val response:String,
    @SerializedName("results-for") val resultsFor:String,
    @SerializedName("results") val superheroes:  List<SuperHeroesItemResponse>
)

 data class SuperHeroesItemResponse(
     @SerializedName("id") val superHeroesId:String,
     @SerializedName("name") val name:String,
     @SerializedName("image") val image:SuperheroImage
 )

data class SuperheroImage(@SerializedName("url") val url:String)