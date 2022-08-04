package com.vule.demotmdb.data.remote

import com.vule.demotmdb.models.network.DiscoverMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {

    @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
    suspend fun fetchDiscoverMovie(@Query("page") page: Int): Response<DiscoverMovieResponse>
}