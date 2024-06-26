package com.example.superapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superapp.data.ApiService
import com.example.superapp.data.DetailSuperHeroActivity
import com.example.superapp.data.SuperHeroAdapter
import com.example.superapp.data.SuperHeroesData
import com.example.superapp.data.SuperHeroesItemResponse
import com.example.superapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperHeroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
        searchByName("a")
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
            adapter = SuperHeroAdapter {navigateToDetail(it) }
            binding.reyclerView.setHasFixedSize(true)
            binding.reyclerView.layoutManager = LinearLayoutManager(this)
            binding.reyclerView.adapter = adapter

    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {

            try {
            val myResponse: Response<SuperHeroesData> =
                retrofit.create(ApiService::class.java).getSuperHeroes(query)

            // if para ver si funciona
            if (myResponse.isSuccessful) {
                Log.i("Peticion", "funciona")
                val response: SuperHeroesData? = myResponse.body()
                if(response != null) {
                    Log.i("response", response.toString())



                    runOnUiThread {
                        if (response.response == "success") {   //esta parte es para entender que el codigo fue correcto
                            adapter.updateList(response.superheroes)
                        } else {
                            adapter.updateList(emptyList())

                                     // si da un error mostrar otra cosa
                        }
                        binding.progressBar.isVisible = false
                    }
                }   // correr algo en el hilo principal algo que este entre llaves



            } else {
                Log.i("Peticion", "No funciona")

            }

            } catch (e: Exception) {
                e.printStackTrace()
            }



        }


    }

    // para navegar entre pantalllas necesitamos esta funcion
    private fun navigateToDetail(id:String){
        val intent = Intent(this, DetailSuperHeroActivity::class.java)
        intent.putExtra("EXTRA_ID", id)
        startActivity(intent)
    }

}
