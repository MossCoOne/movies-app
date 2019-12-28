package com.mossco.za.moviesapp.network

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesServiceApi {
    @GET("now_playing?")
    fun getCurrentlyPlayingMoviesAsync(@Query("api_key") apiKey: String): NetworkMoviesResponse
}