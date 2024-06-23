package com.example.superapp.data

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SuperHeroAdapter(var superheroList:List<SuperHeroesItemResponse> = emptyList()) :
    RecyclerView.Adapter<SuperHeroViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {

    }

    override fun getItemCount()= superheroList.size


    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superheroList[position])

    }

}