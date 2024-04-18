package com.example.movieapp.presentation.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.FragmentActorBinding
import com.example.movieapp.databinding.ViewHolderActorBinding
import com.example.movieapp.domain.enteties.Actor

class ActorViewHolder(
    private val binding: ViewHolderActorBinding
): RecyclerView.ViewHolder(binding.root){

    fun bind(actor: Actor){
        with(binding){
            Glide.with(root.context)
                .asBitmap()
                .load(actor.photoUrl)
                .fitCenter()
                .into(actorImage)

            actorName.text = actor.name
        }
    }
}