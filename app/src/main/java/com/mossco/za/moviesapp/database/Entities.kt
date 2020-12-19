package com.mossco.za.moviesapp.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Movie(
    @PrimaryKey
    val movieId: Int? = 0,
    val popularity: Double? = 0.0,
    val voteCount: Int? = 0,
    val isVideo: Boolean? = false,
    val posterPath: String? = null,
    val isAdult: Boolean? = false,
    val backdropPath: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val genreIds: List<Int>? = null,
    val title: String? = null,
    val voteAverage: Double? = 0.0,
    val overview: String? = null,
    val releaseDate: String? = null)

