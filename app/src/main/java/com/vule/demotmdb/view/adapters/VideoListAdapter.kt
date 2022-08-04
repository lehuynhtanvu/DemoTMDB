package com.vule.demotmdb.view.adapters

import android.view.View
import com.skydoves.whatif.whatIfNotNull
import com.vule.demotmdb.R
import com.vule.demotmdb.models.Resource
import com.vule.demotmdb.models.Video
import com.vule.demotmdb.view.custom.SectionRow
import com.vule.demotmdb.view.viewholders.VideoListViewHolder

class VideoListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Video>())
    }

    fun addVideoList(resource: Resource<List<Video>>) {
        resource.data.whatIfNotNull {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_video

    override fun viewHolder(layout: Int, view: View) = VideoListViewHolder(view)
}
