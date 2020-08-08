package com.saptarshisamanta.blog.data

data class Post(
    var _id:String,
    //val profile_pic:String,
    var username:String,
    val post:String,
    val post_pic:String ,
    var fav_count:Int,
    var comment_count:Int)