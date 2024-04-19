package com.example.movieapp.presentation.adapters.callBacks

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.MoviePoster

class MoviePagerDiffCallback: DiffUtil.ItemCallback<MoviePoster>() {
    override fun areItemsTheSame(oldItem: MoviePoster, newItem: MoviePoster): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MoviePoster, newItem: MoviePoster): Boolean {
        return oldItem == newItem
    }
}