package com.example.api_movie_db.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_movie_db.data.api.ApiClient
import com.example.api_movie_db.data.api.ApiService
import com.example.api_movie_db.data.api.model.MovieResponse
import com.example.api_movie_db.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(listOf())
        binding.recyclerView.adapter = movieAdapter

        fetchMovies()
    }

    private fun fetchMovies() {
        // Ganti dengan API key dan access token Anda
        val accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMTZlNjc1OTJjZjgzMGFjZWE3MjY4OGMzMmQ5ZmUyNCIsIm5iZiI6MTcyODgyMzQ4NC44Njk4OTksInN1YiI6IjY3MGI4M2M4YjE1ZDk3YjFhOTNjNmQ1MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.KFEWov2D88boTE2CpSq4RPd9zVotTd_1rS7c7MnHHHs"

        // Buat instance ApiService
        val apiService = ApiClient.getClient().create(ApiService::class.java)

        // Panggil API dengan menambahkan api_key dan access_token
        val call = apiService.getPopularMovies(accessToken)

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                try {
                    if (response.isSuccessful) {
                        val movies = response.body()?.results ?: listOf()
                        movieAdapter.updateMovies(movies)

                        // Log untuk memastikan ada data yang diterima
                        if (movies.isNotEmpty()) {
                            for (movie in movies) {
                                println("Movie: ${movie.title}")
                            }
                        } else {
                            Toast.makeText(applicationContext, "No movies found.", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // Log jika response gagal
                        println("Failed to fetch movies: ${response.code()}")
                        Toast.makeText(this@MainActivity, "Failed to fetch movies: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    println("Error processing movies: ${e.message}")
                    e.printStackTrace()
                    Toast.makeText(this@MainActivity, "Error processing movies: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                try {
                    // Penanganan kegagalan request (seperti jaringan yang buruk)
                    Toast.makeText(this@MainActivity, "Error fetching movies: ${t.message}", Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                } catch (e: Exception) {
                    // Menangkap jika ada error saat menampilkan pesan atau proses lainnya
                    Toast.makeText(this@MainActivity, "Unexpected error: ${e.message}", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
        })
    }


}

