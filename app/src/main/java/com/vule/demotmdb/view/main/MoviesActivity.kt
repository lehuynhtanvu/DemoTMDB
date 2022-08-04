package com.vule.demotmdb.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.vule.demotmdb.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_movies.*

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        val fragment = MovieListFragment()
        changeFragment(fragment)
    }

    @JvmOverloads
    fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainer, fragment)
        transaction.commit()
    }
}