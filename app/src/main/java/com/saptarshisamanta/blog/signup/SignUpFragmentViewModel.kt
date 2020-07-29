package com.saptarshisamanta.blog.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import com.saptarshisamanta.blog.data.User
import com.saptarshisamanta.blog.network.BlogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpFragmentViewModel : ViewModel() {
    private var status = 0
    fun signUp(user: User):Int {
        BlogApi.blogApiService.signUp(user).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("faild", t.message.toString())
                status = 1001
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                status = response.code()
            }

        })
        return status
    }

}
