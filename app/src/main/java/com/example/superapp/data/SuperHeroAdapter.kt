package com.example.superapp.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superapp.R

class SuperHeroAdapter( var superheroList:List<SuperHeroesItemResponse> = emptyList()) :
    RecyclerView.Adapter<SuperHeroViewHolder>(){

         fun updateList(superheroList:List<SuperHeroesItemResponse>){
             this.superheroList = superheroList
             notifyDataSetChanged()
         }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater =  LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun getItemCount()= superheroList.size


    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superheroList[position])

    }

}