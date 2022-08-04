package com.vule.demotmdb.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.vule.demotmdb.models.Keyword
import com.vule.demotmdb.models.Resource
import com.vule.demotmdb.models.Review
import com.vule.demotmdb.models.Video
import com.vule.demotmdb.repository.MovieRepository
import com.vule.demotmdb.utils.AbsentLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {

    private val movieIdLiveData: MutableLiveData<Int> = MutableLiveData()
    val keywordListLiveData: LiveData<Resource<List<Keyword>>>
    val videoListLiveData: LiveData<Resource<List<Video>>>
    val reviewListLiveData: LiveData<Resource<List<Review>>>

    init {
        Timber.d("Injection MovieDetailViewModel")

        this.keywordListLiveData = movieIdLiveData.switchMap {
            movieIdLiveData.value?.let {
                repository.loadKeywordList(it)
            } ?: AbsentLiveData.create()
        }

        this.videoListLiveData = movieIdLiveData.switchMap {
            movieIdLiveData.value?.let {
                repository.loadVideoList(it)
            } ?: AbsentLiveData.create()
        }

        this.reviewListLiveData = movieIdLiveData.switchMap {
            movieIdLiveData.value?.let {
                repository.loadReviewsList(it)
            } ?: AbsentLiveData.create()
        }
    }

    fun postMovieId(id: Int) = movieIdLiveData.postValue(id)
}