package com.example.superapp.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superapp.R

class DetailSuperHeroActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_super_hero)
    }
}