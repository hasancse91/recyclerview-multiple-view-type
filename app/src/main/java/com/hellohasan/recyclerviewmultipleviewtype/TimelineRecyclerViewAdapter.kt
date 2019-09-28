package com.hellohasan.recyclerviewmultipleviewtype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TimelineRecyclerViewAdapter(private val postDataList : List<PostData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val POST_TYPE_TEXT = 1
    private val POST_TYPE_IMAGE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return if (viewType == POST_TYPE_TEXT) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_text_post, parent, false)

            TextPostViewHolder(view) //object of TextPostViewHolder will return
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_post, parent, false)

            ImagePostViewHolder(view) //object of ImagePostViewHolder will return
        }
    }

    override fun getItemCount(): Int {
        return postDataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val postData = postDataList[position]
        val context = holder.itemView.context

        if (holder.itemViewType == POST_TYPE_TEXT) {
            val viewHolder = holder as TextPostViewHolder

            viewHolder.profileName.text = postData.userName
            Glide.with(context).load(postData.userProfilePhotoUrl).into(viewHolder.profilePhoto)
            viewHolder.timeStamp.text = postData.timeStamp
            viewHolder.postDescription.text = postData.postDescription

            viewHolder.itemView.setOnClickListener {
                Toast.makeText(context, "Text type post", Toast.LENGTH_SHORT).show()
            }

        } else {
            val viewHolder = holder as ImagePostViewHolder

            viewHolder.profileName.text = postData.userName
            Glide.with(context).load(postData.userProfilePhotoUrl).into(viewHolder.profilePhoto)
            viewHolder.timeStamp.text = postData.timeStamp
            viewHolder.postDescription.text = postData.postDescription

            Glide.with(holder.itemView.context).load(postData.postImageUrl).into(viewHolder.imageView)

            viewHolder.itemView.setOnClickListener {
                Toast.makeText(context, "Image type post", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (postDataList[position].postImageUrl.isEmpty()) POST_TYPE_TEXT else POST_TYPE_IMAGE
    }
}