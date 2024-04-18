package com.example.movieapp.presentation.adapters.callBacks

import androidx.recyclerview.widget.DiffUtil
import com.example.movieapp.domain.enteties.Actor

class ActorDiffCallBack: DiffUtil.ItemCallback<Actor>() {
    override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean {
        return oldItem == newItem
    }
}