package com.vule.demotmdb.view.viewholders

import android.content.Intent
import android.net.Uri
import android.view.View
import com.bumptech.glide.Glide
import com.vule.demotmdb.api.Api
import com.vule.demotmdb.models.Video
import kotlinx.android.synthetic.main.item_video.view.*

class VideoListViewHolder constructor(
    val view: View
) : BaseViewHolder(view) {

    private lateinit var video: Video

    override fun bindData(data: Any) {
        if (data is Video) {
            video = data
            drawItem()
        }
    }

    private fun drawItem() {
        itemView.run {
            item_video_title.text = video.name
            Glide.with(context)
                .load(Api.getYoutubeThumbnailPath(video.key))
                .into(item_video_cover)
        }
    }

    override fun onClick(v: View?) =
        context().startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(Api.getYoutubeVideoPath(video.key)))
        )

    override fun onLongClick(v: View?) = false
}