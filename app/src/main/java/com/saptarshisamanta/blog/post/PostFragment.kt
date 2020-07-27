package com.saptarshisamanta.blog.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saptarshisamanta.blog.adapter.PostAdapter
import com.saptarshisamanta.blog.adapter.PostListener
import com.saptarshisamanta.blog.databinding.FragmentPostBinding
    lateinit var  postAdapter:PostAdapter

class PostFragment : Fragment(){
    private lateinit var fragmentPostBinding:FragmentPostBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentPostBinding = FragmentPostBinding.inflate(inflater,container,false)
        postAdapter = PostAdapter(PostListener { TODO() })
        return fragmentPostBinding.root
    }
}