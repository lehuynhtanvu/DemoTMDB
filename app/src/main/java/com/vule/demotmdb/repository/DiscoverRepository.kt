package com.vule.demotmdb.repository

import androidx.lifecycle.LiveData
import com.vule.demotmdb.api.ApiResponse
import com.vule.demotmdb.api.TheDiscoverService
import com.vule.demotmdb.mapper.MovieResponseMapper
import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.models.Resource
import com.vule.demotmdb.models.network.DiscoverMovieResponse
import com.vule.demotmdb.room.MovieDao
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiscoverRepository @Inject constructor(
    val discoverService: TheDiscoverService,
    val movieDao: MovieDao
) : Repository {

    init {
        Timber.d("Injection DiscoverRepository")
    }

    fun loadMovies(page: Int): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundRepository<List<Movie>, DiscoverMovieResponse, MovieResponseMapper>() {
            override fun saveFetchData(items: DiscoverMovieResponse) {
                for (item in items.results) {
                    item.page = page
                }
                movieDao.insertMovieList(movies = items.results)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Movie>> {
                return movieDao.getMovieList(page_ = page)
            }

            override fun fetchService(): LiveData<ApiResponse<DiscoverMovieResponse>> {
                return discoverService.fetchDiscoverMovie(page = page)
            }

            override fun mapper(): MovieResponseMapper {
                return MovieResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed $message")
            }
        }.asLiveData()
    }
}
