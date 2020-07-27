package com.saptarshisamanta.blog.createPost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saptarshisamanta.blog.databinding.FragmentCreatePostBinding

class CreatePostFragment: Fragment() {
    lateinit var fragmentCreatePostBinding: FragmentCreatePostBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentCreatePostBinding = FragmentCreatePostBinding.inflate(inflater,container,false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}