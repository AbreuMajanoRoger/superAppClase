package com.example.superapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import com.example.superapp.data.ApiService
import com.example.superapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/") // parte estatica o basica
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun initUI(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query:   String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getSuperHeroes(query)
            if (myResponse.isSuccessful) {
                myResponse.body()
                Log.i("Peticion", "funciona")
                runOnUiThread {
                    binding.progressBar.isVisible = false
                }               // correr algo en el hilo principal algo que este entre llaves

            } else {
                Log.i("Peticion", "No funciona")

            }

        }


    }

}
