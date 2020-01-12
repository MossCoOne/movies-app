package com.mossco.za.moviesapp.ui.home

import com.mossco.za.moviesapp.network.NetworkMovie

class NowPlayingMovieItemClickListener(val clickListener: (networkMovie: NetworkMovie) -> Unit) {
    fun onItemClicked(networkMovie: NetworkMovie) = clickListener(networkMovie)
}