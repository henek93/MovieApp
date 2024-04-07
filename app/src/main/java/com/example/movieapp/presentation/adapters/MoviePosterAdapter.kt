package com.example.movieapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.movieapp.R
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.presentation.callBacks.MoviePosterDiffCallback
import com.example.movieapp.presentation.viewHolders.MoviePosterViewHolder
import com.squareup.picasso.Picasso

class MoviePosterAdapter : ListAdapter<Movie, MoviePosterViewHolder>(MoviePosterDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePosterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        return MoviePosterViewHolder(view)
    }


    override fun onBindViewHolder(holder: MoviePosterViewHolder, position: Int) {
        val movie = getItem(position)

        val raiting = movie.rating.raiting
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

            Picasso.get().load(urlPoster).resize(250, 250).into(poster)

            filmNameText.text = movie.name
        }


    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.rating.raiting >= 9.5) {
            GREEN_RAITING
         } else if(item.rating.raiting >= 8.0){
             ORANGE_RAITING
         }else{
             RED_RAITING
        }
    }

    companion object {

        const val GREEN_RAITING = 100
        const val ORANGE_RAITING = 101
        const val RED_RAITING = 102

        const val MAX_POOL_SIZE = 50
    }
}