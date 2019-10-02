# Recyclerview multiple view type (Kotlin)

Suppose, we need to populate a single list with different types of data/view. For example, in a single list of timeline (like Facebook) we have to show various posts. Some posts contain only text, some of them contain text and image and some of them contain video. How can we show different views and handle click event differently?

<img src="https://raw.githubusercontent.com/hasancse91/recyclerview-multiple-view-type/master/data/Screenshot.png" width="250" height="444" />

Look at the above photo. First item of list contains only text. Users may expect to go details page when click on it. Second item contains text and image. Users expects to see full screen image view when click on it. If there were another item with video, users will expect play the video when click on it. Let's dive the source code to implement different types of view in a single `RecyclerView`.

You can download and test sample APK file from [here](https://github.com/hasancse91/recyclerview-multiple-view-type/blob/master/data/app-debug.apk) 

## Source code
This is the Adapter class of `RecyclerView`. This class is extended from `RecyclerView.Adapter<RecyclerView.ViewHolder>()` class.
### Adapter of RecyclerView
```kotlin
class TimelineRecyclerViewAdapter(private val postDataList : List<PostData>): 
                                RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
    
    override fun getItemCount(): Int {
        return postDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (postDataList[position].postImageUrl.isEmpty()) POST_TYPE_TEXT else POST_TYPE_IMAGE
    }
}
```
Check the `getItemViewType()` overrided method end of the above code. This method returns type of the view. This type is using inside `onCreateViewHolder()` and `onBindViewHolder()` methods.
### ViewHolders of RecyclerView
There are two types of view in our example project. First one is `TextPostViewHolder`, which shows only text type post.
```kotlin
class TextPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val profilePhoto = itemView.profilePhoto
    val profileName = itemView.profileName
    val timeStamp = itemView.timeStamp
    val postDescription = itemView.postDescription

}
```
Second one is, `ImagePostViewHolder` to handle image type post.
```kotlin
class ImagePostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val profilePhoto = itemView.profilePhoto
    val profileName = itemView.profileName
    val timeStamp = itemView.timeStamp
    val postDescription = itemView.postDescription
    val imageView = itemView.imageView
}
```
