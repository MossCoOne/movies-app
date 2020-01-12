package com.mossco.za.moviesapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mossco.za.moviesapp.R
import com.mossco.za.moviesapp.databinding.MovieItemLayoutBinding
import com.mossco.za.moviesapp.network.NetworkMovie
import com.mossco.za.moviesapp.ui.home.NowPlayingMoviesAdapter.NowPlayingMoviesViewHolder.Companion.from

class NowPlayingMoviesAdapter :
    ListAdapter<NetworkMovie, NowPlayingMoviesAdapter.NowPlayingMoviesViewHolder>(
        NowPlayingMoviesDiffCallback()
    ) {

    class NowPlayingMoviesDiffCallback : DiffUtil.ItemCallback<NetworkMovie>() {
        override fun areItemsTheSame(oldItem: NetworkMovie, newItem: NetworkMovie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NetworkMovie, newItem: NetworkMovie): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMoviesViewHolder {
        /**
         * Separation of concern :
         * Move the inflation code to ViewHolder Class because it has nothing to with the adapter and belong to the Viewholder
         * */
        return from(parent)
    }


    override fun onBindViewHolder(holder: NowPlayingMoviesViewHolder, position: Int) {
        val currentMovie = getItem(position)
        holder.bindDataToView(currentMovie)
    }

    class NowPlayingMoviesViewHolder private constructor(binding: MovieItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val movieIconImageView: ImageView = binding.movieIconImageView
        val movieTitleTextView: TextView = binding.movieTitleTextView

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
                val binding =
                    MovieItemLayoutBinding.inflate(layoutInflater, parent, false)
                return NowPlayingMoviesViewHolder(binding)
            }
        }

    }
}

