package com.example.api_movie_db.data.api.model

import android.graphics.pdf.PdfDocument.Page

data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
)
