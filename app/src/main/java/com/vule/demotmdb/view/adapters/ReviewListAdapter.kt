package com.vule.demotmdb.view.adapters

import android.view.View
import com.skydoves.whatif.whatIfNotNull
import com.vule.demotmdb.R
import com.vule.demotmdb.models.Resource
import com.vule.demotmdb.models.Review
import com.vule.demotmdb.view.custom.SectionRow
import com.vule.demotmdb.view.viewholders.ReviewListViewHolder

class ReviewListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Review>())
    }

    fun addReviewList(resource: Resource<List<Review>>) {
        resource.data.whatIfNotNull {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_review

    override fun viewHolder(layout: Int, view: View) = ReviewListViewHolder(view)
}
