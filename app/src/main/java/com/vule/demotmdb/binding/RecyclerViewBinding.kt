package com.vule.demotmdb.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skydoves.whatif.whatIfNotNullOrEmpty
import com.vule.demotmdb.extension.bindResource
import com.vule.demotmdb.extension.visible
import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.models.Resource
import com.vule.demotmdb.models.Review
import com.vule.demotmdb.models.Video
import com.vule.demotmdb.view.adapters.BaseAdapter
import com.vule.demotmdb.view.adapters.MovieListAdapter
import com.vule.demotmdb.view.adapters.ReviewListAdapter
import com.vule.demotmdb.view.adapters.VideoListAdapter
import com.vule.demotmdb.view.custom.RecyclerViewPaginator
import com.vule.demotmdb.view.main.MovieListViewModel

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: BaseAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, resource: Resource<List<Movie>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? MovieListAdapter
        adapter?.addMovieList(it)
    }
}

@BindingAdapter("moviePagination")
fun bindMoviePagination(view: RecyclerView, viewModel: MovieListViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        isLoading = { false},
        loadMore = { viewModel.postMoviePage(it) },
        onLast = { false }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("adapterVideoList")
fun bindAdapterVideoList(view: RecyclerView, resource: Resource<List<Video>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? VideoListAdapter
        adapter?.addVideoList(it)
        it.data.whatIfNotNullOrEmpty {
            view.visible()
        }
    }
}

@BindingAdapter("adapterReviewList")
fun bindAdapterReviewList(view: RecyclerView, resource: Resource<List<Review>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? ReviewListAdapter
        adapter?.addReviewList(it)
        it.data.whatIfNotNullOrEmpty {
            view.visible()
            view.setHasFixedSize(true)
        }
    }
}