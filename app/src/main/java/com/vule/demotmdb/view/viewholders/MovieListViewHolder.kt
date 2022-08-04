package com.vule.demotmdb.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.vule.demotmdb.api.Api
import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.view.detail.MovieDetailActivity
import kotlinx.android.synthetic.main.item_poster.view.*

class MovieListViewHolder constructor(
    val view: View
) : BaseViewHolder(view) {

    private lateinit var movie: Movie

    @Throws(Exception::class)
    override fun bindData(data: Any) {
        if (data is Movie) {
            movie = data
            drawItem()
        }
    }

    private fun drawItem() {
        itemView.run {
            item_poster_title.text = movie.title
            movie.poster_path?.let {
                Glide.with(context)
                    .load(Api.getPosterPath(it))
                    .into(item_poster_post)
            }
        }
    }

    override fun onClick(v: View?) = MovieDetailActivity.startActivityModel(context(), movie)

    override fun onLongClick(v: View?) = false
}