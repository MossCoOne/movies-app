package com.mossco.za.moviesapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mossco.za.moviesapp.R
import com.mossco.za.moviesapp.network.NetworkMovie
import com.mossco.za.moviesapp.ui.home.NowPlayingMoviesAdapter.NowPlayingMoviesViewHolder.Companion.from

class NowPlayingMoviesAdapter :
    RecyclerView.Adapter<NowPlayingMoviesAdapter.NowPlayingMoviesViewHolder>() {


    private var latestMoviesList = listOf<NetworkMovie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMoviesViewHolder {
        /**
         * Separation of concern :
         * Move the inflation code to ViewHolder Class because it has nothing to with the adapter and belong to the Viewholder
         * */
        return from(parent)
    }


    override fun getItemCount(): Int {
        return latestMoviesList.size
    }

    override fun onBindViewHolder(holder: NowPlayingMoviesViewHolder, position: Int) {
        val currentMovie: NetworkMovie = latestMoviesList.get(index = position)
        holder.bindDataToView(currentMovie)
    }

    class NowPlayingMoviesViewHolder private constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val movieIconImageView: ImageView = itemView.findViewById(R.id.movieIconImageView)
        val movieTitleTextView: TextView = itemView.findViewById(R.id.movieTitleTextView)

        fun bindDataToView(currentMovie: NetworkMovie) {
            movieTitleTextView.text = currentMovie.title
        }

        /**
         * Remember boss to create a static field you need to wrap it with a companion object
         * The viewholder is now a singleton and we can make the constructor private
         * */
        companion object {
            fun from(parent: ViewGroup): NowPlayingMoviesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.movie_item_layout, parent, false)
                return NowPlayingMoviesViewHolder(view)
            }
        }

    }
}

