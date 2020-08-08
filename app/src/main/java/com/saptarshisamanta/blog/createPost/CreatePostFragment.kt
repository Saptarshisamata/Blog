package com.saptarshisamanta.blog.createPost

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.saptarshisamanta.blog.databinding.FragmentCreatePostBinding

class CreatePostFragment: Fragment() {
    private var status:Int =0
    private lateinit var fragmentCreatePostBinding: FragmentCreatePostBinding
    private lateinit var createPostViewModel: CreatePostViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentCreatePostBinding = FragmentCreatePostBinding.inflate(inflater,container,false)
        createPostViewModel = ViewModelProvider(this).get(CreatePostViewModel::class.java)
        fragmentCreatePostBinding.createpost.setOnClickListener {
            createPost()
        }
        return fragmentCreatePostBinding.root
    }

    private fun createPost(){

        val post:String = fragmentCreatePostBinding.postBody.text.toString()
        if (post.isEmpty()){
            return
        }else{
            val sharedPreferences = context?.getSharedPreferences("USERNAME",Context.MODE_PRIVATE)
            val username = sharedPreferences!!.getString("username","default").toString()
            val parameter:HashMap<String,String> = HashMap()
            parameter["username"] ="de"
            parameter["post"] = post
            parameter["imageurl"] = "http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg"
            status = createPostViewModel.createPost(parameter)
            //TODO("handle status code")
            when (status) {
                201 -> {
                    Toast.makeText(context,"done",Toast.LENGTH_SHORT).show()

                }
                else -> {
                    Toast.makeText(context,"error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validatePost(body:String):Boolean{
        return body.isNotEmpty()
    }
}