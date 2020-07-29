package com.saptarshisamanta.blog.login

import androidx.lifecycle.ViewModel
import com.saptarshisamanta.blog.data.Token
import com.saptarshisamanta.blog.network.BlogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInFragmentViewModel : ViewModel(){
    private var status =0
    private var token:String? = null
    init {

    }
    fun logIn(fields:Map<String,String>):Int{
        BlogApi.blogApiService.logIn(fields).enqueue(object : Callback<Token>{
            override fun onFailure(call: Call<Token>, t: Throwable) {
                status =1001
            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                status = response.code()
                token = response.body()!!.token
            }
        })
        return status
    }
}