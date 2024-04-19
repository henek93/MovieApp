package com.example.movieapp.presentation.adapters.callBacks

import androidx.recyclerview.widget.DiffUtil
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.enteties.ActorPoster

class ActorDiffCallBack: DiffUtil.ItemCallback<ActorPoster>() {
    override fun areItemsTheSame(oldItem: ActorPoster, newItem: ActorPoster): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ActorPoster, newItem: ActorPoster): Boolean {
        return oldItem == newItem
    }
}