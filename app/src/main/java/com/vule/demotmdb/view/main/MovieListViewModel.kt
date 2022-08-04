package com.vule.demotmdb.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.models.Resource
import com.vule.demotmdb.repository.DiscoverRepository
import com.vule.demotmdb.repository.MovieRepository
import com.vule.demotmdb.utils.AbsentLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel  @Inject constructor(
    private val discoverRepository: DiscoverRepository
): ViewModel() {

    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<Resource<List<Movie>>>


    init {
        Timber.d("injection MainActivityViewModel")

        movieListLiveData = moviePageLiveData.switchMap {
            moviePageLiveData.value?.let { discoverRepository.loadMovies(it) }
                ?: AbsentLiveData.create()
        }
    }

    fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)
}