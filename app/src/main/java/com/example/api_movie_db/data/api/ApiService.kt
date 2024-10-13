package com.example.api_movie_db.data.api

import com.example.api_movie_db.data.api.model.MovieResponse
import com.example.api_movie_db.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.Header

interface ApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Header("Authorization") token: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Call<MovieResponse>
}
