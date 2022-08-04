package com.vule.demotmdb.models.network

import com.vule.demotmdb.models.NetworkResponseModel
import com.vule.demotmdb.models.Video

data class VideoListResponse(
    val id: Int,
    val results: List<Video>
) : NetworkResponseModel
