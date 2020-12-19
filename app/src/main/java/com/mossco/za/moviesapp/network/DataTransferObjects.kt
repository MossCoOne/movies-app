package com.mossco.za.moviesapp.network

import com.mossco.za.moviesapp.database.Movie
import com.squareup.moshi.Json

data class NetworkMoviesResponse(@Json(name = "results") val movies: List<NetworkMovie>? = null)

data class NetworkMovie(
    val popularity: Double? = null,
    @Json(name = "vote_count") val voteCount: Int? = null,
    @Json(name = "video")
    val isVideo: Boolean? = null,
    @Json(name = "poster_path") val posterPath: String? = null,
    @Json(name = "adult")
    val isAdult: Boolean? = null,
    val id: Int? = null,
    @Json(name = "backdrop_path") val backdropPath: String? = null,
    @Json(name = "original_language") val originalLanguage: String? = null,
    @Json(name = "original_title") val originalTitle: String? = null,
    @Json(name = "genre_ids") val genreIds: List<Int>? = null,
    val title: String? = null,
    @Json(name = "vote_average") val voteAverage: Double? = null,
    val overview: String? = null,
    @Json(name = "release_date") val releaseDate: String? = null
)

fun List<NetworkMovie>.asDatabaseModel(): Array<Movie> {
    return map {
        Movie(
            movieId = it.id,
            popularity = it.popularity,
            voteCount = it.voteCount,
            isVideo = it.isVideo,
            posterPath = it.posterPath,
            isAdult = it.isAdult,
            backdropPath = it.backdropPath,
            originalLanguage = it.originalLanguage,
            originalTitle = it.originalTitle,
            genreIds = it.genreIds,
            title = it.title,
            voteAverage = it.voteAverage,
            overview = it.overview,
            releaseDate = it.releaseDate
        )
    }.toTypedArray()
}


