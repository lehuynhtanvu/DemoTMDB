package com.vule.demotmdb.binding

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.chip.ChipGroup
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty
import com.vule.demotmdb.api.Api
import com.vule.demotmdb.extension.addPrimaryChip
import com.vule.demotmdb.extension.bindResource
import com.vule.demotmdb.extension.requestGlideListener
import com.vule.demotmdb.extension.visible
import com.vule.demotmdb.models.Keyword
import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.models.Resource

@BindingAdapter("visibilityByResource")
fun bindVisibilityByResource(view: View, resource: Resource<List<Any>>?) {
    view.bindResource(resource) {
        it.data.whatIfNotNull {
            view.visible()
        }
        it.data
    }
}

@BindingAdapter("mapKeywordList")
fun bindMapKeywordList(view: ChipGroup, resource: Resource<List<Keyword>>?) {
    view.bindResource(resource) {
        it.data.whatIfNotNullOrEmpty { keywords ->
            view.visible()
            keywords.forEach { keyword -> view.addPrimaryChip(keyword.name) }
        }
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: TextView, movie: Movie) {
    view.text = "Release Date : ${movie.release_date}"
}

@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: ImageView, movie: Movie) {
    if (movie.backdrop_path != null) {
        Glide.with(view.context).load(Api.getBackdropPath(movie.backdrop_path))
            .listener(view.requestGlideListener())
            .into(view)
    } else {
        Glide.with(view.context).load(Api.getBackdropPath(movie.poster_path!!))
            .listener(view.requestGlideListener())
            .into(view)
    }
}