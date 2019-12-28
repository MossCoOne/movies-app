package com.mossco.za.moviesapp.network

import com.squareup.moshi.Json

data class NetworkMoviesResponse(@Json(name = "results") val movies: List<NetworkMovie>)

data class NetworkMovie(val popularity: Double? = null,
                        @Json(name = "vote_count") val voteCount: Int? = null,
                        val video: Boolean? = null,
                        @Json(name = "poster_path") val posterPath: String? = null,
                        val adult: Boolean? = null,
                        val id: Int? = null,
                        @Json(name = "backdrop_path") val backdropPath: String? = null,
                        @Json(name = "original_language") val originalLanguage: String? = null,
                        @Json(name = "original_title") val originalTitle: String? = null,
                        @Json(name = "genre_ids") val genreIds: List<Int>? = null,
                        val title: String? = null,
                        @Json(name = "vote_average") val voteAverage: Double? = null,
                        val overview: String? = null,
                        @Json(name = "release_date") val releaseDate: String? = null)
