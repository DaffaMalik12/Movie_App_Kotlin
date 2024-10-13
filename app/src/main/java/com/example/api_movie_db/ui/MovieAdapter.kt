package com.example.api_movie_db.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_movie_db.data.api.model.Movie
import com.example.api_movie_db.databinding.ItemMovieBinding
import com.example.api_movie_db.utils.Constant

class MovieAdapter(private var movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun updateMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movieTitle.text = movie.title
            binding.movieReleaseDate.text = movie.release_date // Menampilkan tanggal rilis
            binding.movieRating.text = "Rating: ${movie.vote_average}" // Menampilkan rating
            binding.movieOverview.text = movie.overview // Menampilkan deskripsi

            Glide.with(binding.root.context)
                .load(Constant.IMAGE_BASE_URL + movie.poster_path)
                .into(binding.moviePoster)
        }
    }
}
