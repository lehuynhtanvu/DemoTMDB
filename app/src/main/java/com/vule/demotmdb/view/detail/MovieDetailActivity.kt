package com.vule.demotmdb.view.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.skydoves.whatif.whatIfNotNull
import com.vule.demotmdb.R
import com.vule.demotmdb.compose.ViewModelActivity
import com.vule.demotmdb.databinding.ActivityMovieDetailBinding
import com.vule.demotmdb.extension.applyToolbarMargin
import com.vule.demotmdb.extension.simpleToolbarWithHome
import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.view.adapters.ReviewListAdapter
import com.vule.demotmdb.view.adapters.VideoListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_movie_detail.*

@AndroidEntryPoint
class MovieDetailActivity : ViewModelActivity() {

    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding<ActivityMovieDetailBinding>(R.layout.activity_movie_detail).run {
            lifecycleOwner = this@MovieDetailActivity
            viewModel = this@MovieDetailActivity.viewModel.apply { postMovieId(getMovieFromIntent()?.id ?: 0) }
            movie = getMovieFromIntent()
            videoAdapter = VideoListAdapter()
            reviewAdapter = ReviewListAdapter()
        }
        initializeUI()
    }

    private fun initializeUI() {
        applyToolbarMargin(movie_detail_toolbar)
        simpleToolbarWithHome(movie_detail_toolbar, getMovieFromIntent()?.title ?: "")
    }

    private fun getMovieFromIntent() = intent.getParcelableExtra(movieId) as? Movie

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return false
    }

    companion object {
        private const val movieId = "movie"
        fun startActivityModel(context: Context?, movie: Movie) {
            context.whatIfNotNull {
                val intent = Intent(it, MovieDetailActivity::class.java).apply { putExtra(movieId, movie) }
                it.startActivity(intent)
            }
        }
    }
}