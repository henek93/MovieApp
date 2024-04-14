package com.example.movieapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.movieapp.R
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.presentation.adapters.callBacks.MoviePagerDiffCallback
import com.squareup.picasso.Picasso


class MovieViewPagerAdapter : ListAdapter<Movie, MovieViewPagerAdapter.PagerVh>(MoviePagerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVh {
        return PagerVh(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_pager, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PagerVh, position: Int) {
        val item = getItem(position)

        Picasso.get()
            .load(item.backdrop.url)
            .into(holder.backdrop)

        Picasso.get()
            .load(item.logo.url)
            .into(holder.logo)

        holder.description.text = item.description
    }




    class PagerVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val backdrop = itemView.findViewById<ImageView>(R.id.imageViewBackdrop)
        val logo = itemView.findViewById<ImageView>(R.id.image_view_Logo)
        val description = itemView.findViewById<TextView>(R.id.textViewRating)
    }
}
