package com.example.movieapp.presentation.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.MoviePoster
import com.example.movieapp.presentation.adapters.callBacks.MoviePosterDiffCallback
import com.example.movieapp.presentation.viewHolders.MoviePosterViewHolder
import com.squareup.picasso.Picasso

class MoviePosterAdapter : ListAdapter<MoviePoster, MoviePosterViewHolder>(MoviePosterDiffCallback()) {

    var onPosterClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePosterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        return MoviePosterViewHolder(view)
    }


    override fun onBindViewHolder(holder: MoviePosterViewHolder, position: Int) {
        val movie = getItem(position)

        val raiting = movie.rating.rating
        var resId: Int

        if (raiting > 9.5){
            resId = R.drawable.shape_green
        }
        else if (raiting > 8.0){
            resId = R.drawable.shape_orange
        }
        else
            resId = R.drawable.shape_red

        val urlPoster = movie.poster.url

        with(holder) {
            pgText.text = movie.rating.toString()
            pgText.setBackgroundResource(resId)

            Glide.with(holder.view.context)
                .asBitmap()
                .load(urlPoster)
                .fitCenter()
                .into(poster)


            filmNameText.text = movie.name
        }

        holder.view.setOnClickListener {
            onPosterClickListener?.invoke(movie.id)
        }
    }


    companion object {

        const val GREEN_RAITING = 100
        const val ORANGE_RAITING = 101
        const val RED_RAITING = 102

        const val MAX_POOL_SIZE = 50
    }
}