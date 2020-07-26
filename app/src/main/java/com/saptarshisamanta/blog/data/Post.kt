package com.saptarshisamanta.blog.data

data class Post(
    val _ID:String,
    val profile_pic:String,
    val name:String,
    val post:String,
    val post_pic:String,
    val fav_count:Int,
    val comment_count:Int)