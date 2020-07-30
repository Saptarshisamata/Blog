package com.saptarshisamanta.blog.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.saptarshisamanta.blog.adapter.PostAdapter
import com.saptarshisamanta.blog.adapter.PostListener
import com.saptarshisamanta.blog.data.Post
import com.saptarshisamanta.blog.databinding.FragmentPostBinding
    lateinit var  postAdapter:PostAdapter

class PostFragment : Fragment(){
    private lateinit var fragmentPostBinding:FragmentPostBinding
    private lateinit var postFragmentViewModel: PostFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentPostBinding = FragmentPostBinding.inflate(inflater,container,false)
        postFragmentViewModel = ViewModelProvider(this).get(PostFragmentViewModel::class.java)
        postAdapter = PostAdapter(PostListener {id->
            Toast.makeText(context, "aaa$id",Toast.LENGTH_SHORT).show()
        })
        fragmentPostBinding.postsRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentPostBinding.postsRecyclerView.adapter = postAdapter
        val list = ArrayList<Post>()
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        list.addAll(listOf(Post("aa","aaa","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100)))
        postAdapter.submitList(list)


        return fragmentPostBinding.root
    }
}