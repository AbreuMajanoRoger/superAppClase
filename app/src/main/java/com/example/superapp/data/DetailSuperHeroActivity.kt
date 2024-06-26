package com.example.superapp.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superapp.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperHeroActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_super_hero)

    }

    private fun getsuperHeroBiography(id: String) {

        getRetrofit().create(ApiService::class.java)
    }



    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/") // parte estatica o basica
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}