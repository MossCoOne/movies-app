package com.mossco.za.moviesapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mossco.za.moviesapp.network.NetworkMovie

@BindingAdapter("movieTitleString")
fun TextView.setMovieTitle(movie: NetworkMovie) {
    text = movie.title
}