package com.example.superapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superapp.R
import com.example.superapp.data.SuperHeroesItemResponse
import com.example.superapp.viewHolder.SuperHeroViewHolder

class SuperHeroAdapter(var superheroList:List<SuperHeroesItemResponse> = emptyList(),
                       private val onItemSelectd:(String) ->Unit) :
                        RecyclerView.Adapter<SuperHeroViewHolder>(){
                            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
                            val layoutInflater =  LayoutInflater.from(parent.context)
                            return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
                            }

                        override fun getItemCount()= superheroList.size


                         override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
                            holder.bind(superheroList[position], onItemSelectd)

                            }

                        fun updateList(superheroList:List<SuperHeroesItemResponse>){
                         this.superheroList = superheroList
                        notifyDataSetChanged()
                        }

}