package com.example.superapp.data

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superapp.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(SuperHeroesItemResponse: SuperHeroesItemResponse, onItemSelectd: (String) -> Unit) {
        binding.txtViewName.text = SuperHeroesItemResponse.name
        Picasso.get().load(SuperHeroesItemResponse.image.url).into(binding.imgHero)
        binding.root.setOnClickListener { onItemSelectd(SuperHeroesItemResponse.superHeroesId) }
    }
}