package com.saptarshisamanta.blog.createPost

import androidx.lifecycle.ViewModel
import com.saptarshisamanta.blog.network.BlogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreatePostViewModel : ViewModel(){
    var status:Int=0
    fun createPost(fields:Map<String,String>):Int{
        BlogApi.blogApiService.createPost(fields).enqueue(object :Callback<Void>{
            override fun onFailure(call: Call<Void>, t: Throwable) {
                status = 1001
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                status = response.code()
            }

        })
        return status
    }
}