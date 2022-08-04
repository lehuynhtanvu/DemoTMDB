package com.vule.demotmdb.api

import androidx.lifecycle.LiveData
import com.vule.demotmdb.models.network.DiscoverMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheDiscoverService {

    @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
    fun fetchDiscoverMovie(@Query("page") page: Int): LiveData<ApiResponse<DiscoverMovieResponse>>
}
