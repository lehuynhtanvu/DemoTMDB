package com.vule.demotmdb.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vule.demotmdb.R
import com.vule.demotmdb.compose.ViewModelFragment
import com.vule.demotmdb.databinding.FragmentMovieBinding
import com.vule.demotmdb.view.adapters.MovieListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : ViewModelFragment() {

    private val viewModel: MovieListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding<FragmentMovieBinding>(inflater, R.layout.fragment_movie, container)
            .apply {
                viewModel = this@MovieListFragment.viewModel.apply { postMoviePage(1) }
                lifecycleOwner = this@MovieListFragment
                adapter = MovieListAdapter()
            }.root
    }
}