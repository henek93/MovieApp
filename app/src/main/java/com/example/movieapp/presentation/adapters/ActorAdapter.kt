package com.example.movieapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.movieapp.R
import com.example.movieapp.databinding.ViewHolderActorBinding
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.enteties.ActorPoster
import com.example.movieapp.presentation.adapters.callBacks.ActorDiffCallBack
import com.example.movieapp.presentation.ui.actor.ActorViewModel
import com.example.movieapp.presentation.viewHolders.ActorViewHolder

class ActorAdapter : ListAdapter<ActorPoster, ActorViewHolder>(ActorDiffCallBack()) {

    var onActorClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(
            ViewHolderActorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = getItem(position)

        holder.bind(actor)

        holder.itemView.setOnClickListener {
            onActorClickListener?.invoke(actor.id)
        }
    }

}

