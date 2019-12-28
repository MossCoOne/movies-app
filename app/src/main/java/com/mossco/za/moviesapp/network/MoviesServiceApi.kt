package com.mossco.za.moviesapp.network

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesServiceApi {
    @GET("now_playing?")
    fun getCurrentlyPlayingMovies(@Query("api_key") apiKey: String): NetworkMoviesResponse
}