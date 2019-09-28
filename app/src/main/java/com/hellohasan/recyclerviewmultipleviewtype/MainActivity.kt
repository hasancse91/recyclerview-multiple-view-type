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

        val postList = mutableListOf<PostData>()

        for (i in 1..5) {
            val postData1 = PostData(userName = "John Doe", timeStamp = "10:23 PM, 23 Sep 2019", userProfilePhotoUrl = "https://i.imgur.com/L3J7Oge.jpg", postDescription = "This is my first post on this platform. I have uploaded this awesome photo for your opinion. Have a good day", postImageUrl = "https://i.imgur.com/bZDLmPw.jpg")
            val postData2 = PostData(userName = "Grayson Hammond", timeStamp = "9:52 AM, 20 Sep 2019", userProfilePhotoUrl = "https://i.imgur.com/zmJP4JM.png", postDescription = "It is better to lead from behind and to put others in front, especially when you celebrate victory when nice things occur. You take the front line when there is danger. Then people will appreciate your leadership. -[Nelson Mandela]", postImageUrl = "")
            val postData3 = PostData(userName = "Riley Clark", timeStamp = "1:49 PM, 9 Sep 2019", userProfilePhotoUrl = "https://i.imgur.com/KvKTla7.png", postDescription = "It's coffee time!", postImageUrl = "https://i.imgur.com/L0X8CWb.jpg")

            postList.add(postData1)
            postList.add(postData2)
            postList.add(postData3)
        }

        return postList
    }
}
