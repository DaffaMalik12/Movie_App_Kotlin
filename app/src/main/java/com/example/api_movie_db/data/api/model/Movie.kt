package com.example.api_movie_db.data.api.model

data class Movie(
    val popularity: Double,
    val vote_count: Int,
    val id: Int,
    val video: Boolean,
    val vote_average: Double,
    val title: String,
    val release_date: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val backdrop_path: String,
    val adult: Boolean,
    val overview: String,
    val poster_path: String

)
