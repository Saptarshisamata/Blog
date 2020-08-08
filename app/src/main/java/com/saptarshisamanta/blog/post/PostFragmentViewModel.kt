package com.saptarshisamanta.blog.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saptarshisamanta.blog.data.Post
import com.saptarshisamanta.blog.network.BlogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostFragmentViewModel :ViewModel(){
    lateinit var allpost :MutableLiveData<MutableList<Post>>
    fun allPosts(){
        BlogApi.blogApiService.allPost().enqueue(object :Callback<MutableList<Post>>{
            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                //TODO("Not yet implemented")
            }
            override fun onResponse(
                call: Call<MutableList<Post>>,
                response: Response<MutableList<Post>>
            ) {
                allpost.value = response.body()
                //TODO("Not yet implemented")
            }

        })
    }
}
