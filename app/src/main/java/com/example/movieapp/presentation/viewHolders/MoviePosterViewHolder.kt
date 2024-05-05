package com.example.movieapp.presentation.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R

class MoviePosterViewHolder(
    val view: View
): RecyclerView.ViewHolder(view){

    val pgText = view.findViewById<TextView>(R.id.pg_text)
    val filmNameText = view.findViewById<TextView>(R.id.film_name_text)
    val poster = view.findViewById<ImageView>(R.id.movie_image)
    val likeImage = view.findViewById<ImageView>(R.id.movie_like_image)
}