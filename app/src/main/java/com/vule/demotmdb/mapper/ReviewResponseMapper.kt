package com.vule.demotmdb.mapper

import com.vule.demotmdb.models.network.ReviewListResponse

class ReviewResponseMapper : NetworkResponseMapper<ReviewListResponse> {
    override fun onLastPage(response: ReviewListResponse): Boolean {
        return true
    }
}
