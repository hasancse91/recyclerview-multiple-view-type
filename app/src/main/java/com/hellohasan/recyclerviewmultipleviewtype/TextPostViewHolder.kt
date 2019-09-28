package com.hellohasan.recyclerviewmultipleviewtype

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_post_header.view.*

class TextPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val profilePhoto = itemView.profilePhoto
    val profileName = itemView.profileName
    val timeStamp = itemView.timeStamp
    val postDescription = itemView.postDescription

}