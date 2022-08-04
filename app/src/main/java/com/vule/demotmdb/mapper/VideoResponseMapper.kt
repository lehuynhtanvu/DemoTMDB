package com.vule.demotmdb.mapper

import com.vule.demotmdb.models.network.VideoListResponse

class VideoResponseMapper : NetworkResponseMapper<VideoListResponse> {
    override fun onLastPage(response: VideoListResponse): Boolean {
        return true
    }
}
