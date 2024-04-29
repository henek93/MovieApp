package com.example.movieapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.movieapp.databinding.ViewHolderFavouritePosterBinding
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.presentation.adapters.callBacks.MovieFavouritePosterDiffCallBack
import com.example.movieapp.presentation.viewHolders.MovieFavouriteViewHolder

class MovieFavouritePosterAdapter: ListAdapter<Movie, MovieFavouriteViewHolder>(MovieFavouritePosterDiffCallBack()) {

    var onMoviePosterClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieFavouriteViewHolder {
        return MovieFavouriteViewHolder(
            ViewHolderFavouritePosterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieFavouriteViewHolder, position: Int) {
        val movie = getItem(position)

        holder.bind(movie)

        holder.itemView.setOnClickListener {
            onMoviePosterClickListener?.invoke(movie.id)
        }
    }
}