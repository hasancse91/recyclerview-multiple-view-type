package com.hellohasan.recyclerviewmultipleviewtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timelineRecyclerViewAdapter = TimelineRecyclerViewAdapter(getPostDataList())
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = timelineRecyclerViewAdapter
    }

    private fun getPostDataList() : List<PostData> {

        val postList: List<PostData> = listOf()

        for (i in 1..5) {
            val postData1 = PostData(userName = "John Doe", timeStamp = "10:23 PM, 23 Sep 2019", userProfilePhotoUrl = "", postDescription = "", postImageUrl = "")
            val postData2 = PostData(userName = "Grayson Hammond", timeStamp = "9:52 AM, 20 Sep 2019", userProfilePhotoUrl = "", postDescription = "", postImageUrl = "")
            val postData3 = PostData(userName = "Riley Clark", timeStamp = "1:49 PM, 9 Sep 2019", userProfilePhotoUrl = "", postDescription = "", postImageUrl = "")
        }
    }
}
