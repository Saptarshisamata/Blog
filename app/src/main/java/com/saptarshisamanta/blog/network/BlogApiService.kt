package com.saptarshisamanta.blog.network

import com.saptarshisamanta.blog.data.Token
import com.saptarshisamanta.blog.data.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URl :String = "http://192.168.0.102:3030/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URl)
    .build()

interface BlogApiService {
    @POST("userrouters/signup")
    fun signUp(@Body user: User):
            Call<Void>
    @POST("userrouters/login")
    fun logIn(@Body field:Map<String,String>):
            Call<Token>

}

object BlogApi{
    val blogApiService : BlogApiService by lazy {
        retrofit.create(BlogApiService::class.java)
    }
}