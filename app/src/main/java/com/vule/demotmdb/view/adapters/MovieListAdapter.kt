package com.vule.demotmdb.view.adapters

import android.view.View
import com.skydoves.whatif.whatIfNotNull
import com.vule.demotmdb.R
import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.models.Resource
import com.vule.demotmdb.view.custom.SectionRow
import com.vule.demotmdb.view.viewholders.MovieListViewHolder

class MovieListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Movie>())
    }

    fun addMovieList(resource: Resource<List<Movie>>) {
        resource.data.whatIfNotNull {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_poster

    override fun viewHolder(layout: Int, view: View) = MovieListViewHolder(view)
}
