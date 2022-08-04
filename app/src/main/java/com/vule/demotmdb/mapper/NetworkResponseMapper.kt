package com.vule.demotmdb.mapper

import com.vule.demotmdb.models.NetworkResponseModel

interface NetworkResponseMapper<in FROM : NetworkResponseModel> {
    fun onLastPage(response: FROM): Boolean
}
