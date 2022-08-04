package com.vule.demotmdb.mapper

import com.vule.demotmdb.models.network.KeywordListResponse

class KeywordResponseMapper : NetworkResponseMapper<KeywordListResponse> {
    override fun onLastPage(response: KeywordListResponse): Boolean {
        return true
    }
}
