package com.vule.demotmdb.models.network

import com.vule.demotmdb.models.NetworkResponseModel
import com.vule.demotmdb.models.Review

class ReviewListResponse(
    val id: Int,
    val page: Int,
    val results: List<Review>,
    val total_pages: Int,
    val total_results: Int
) : NetworkResponseModel
