package com.vule.demotmdb.models.network

import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.models.NetworkResponseModel

data class DiscoverMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
) : NetworkResponseModel
