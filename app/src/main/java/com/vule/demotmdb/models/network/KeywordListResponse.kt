package com.vule.demotmdb.models.network

import com.vule.demotmdb.models.Keyword
import com.vule.demotmdb.models.NetworkResponseModel

data class KeywordListResponse(
    val id: Int,
    val keywords: List<Keyword>
) : NetworkResponseModel
