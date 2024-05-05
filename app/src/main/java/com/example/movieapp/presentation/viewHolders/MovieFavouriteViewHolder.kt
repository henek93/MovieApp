package com.example.movieapp.presentation.viewHolders

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ViewHolderFavouritePosterBinding
import com.example.movieapp.domain.enteties.Movie

class MovieFavouriteViewHolder(
    val binding: ViewHolderFavouritePosterBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        with(binding) {
            twMovieName.text = movie.name
            twGenres.text = movie.genres.joinToString(",")
            twRating.text = String.format("%.2f", movie.rating.rating)

            if (movie.rating.rating > 7.0) {
                twRating.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.green_rating
                    )
                )
            } else if (movie.rating.rating > 5.0) {
                twRating.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.orange_rating
                    )
                )
            } else {
                twRating.setTextColor(ContextCompat.getColor(itemView.context, R.color.red_rating))
            }

            Glide.with(itemView.context)
                .asBitmap()
                .load(movie.poster.url)
                .fitCenter()
                .into(iwPoster)

            if (movie.isFavourite) {
                icLike.setImageResource(R.drawable.ic_favorite_true)
            } else {
                icLike.setImageResource(R.drawable.ic_favorite)
            }
        }
    }
}