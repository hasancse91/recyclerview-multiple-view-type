# Recyclerview multiple view type

Suppose, we need to populate a single list with different types of data/view. For example, in a single list of timeline (like Facebook) we have to show various posts. Some posts contain only text, some of them contain text and image and some of them contain video. How can we show different views and handle click event differently?

<img src="https://raw.githubusercontent.com/hasancse91/recyclerview-multiple-view-type/master/data/Screenshot.png" width="250" height="444" />

Look at the above photo. First item of list contains only text. Users may expect to go details page when click on it. Second item contains text and image. Users expects to see full screen image view when click on it. If there were another item with video, users will expect play the video when click on it. Let's dive the source code to implement different types of view in a single `RecyclerView`.
