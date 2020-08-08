package com.saptarshisamanta.blog.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.observe
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
        fragmentPostBinding.lifecycleOwner = this
        var list : ArrayList<Post> = ArrayList()
        var li : MutableList<Post> = mutableListOf()

        postAdapter = PostAdapter(PostListener({
//            li.add(Post("11","qq","aaaaaaaaa","http://i.ytimg.com/vi/QMCIR-e9D5Q/maxresdefault.jpg",100,100))
//            postAdapter.submitList(li.toMutableList())
            Toast.makeText(context,"post clicked",Toast.LENGTH_SHORT).show()
        },{
//            li[it.toInt()-1].fav_count +=1
//            postAdapter.notifyItemChanged(it.toInt()-1)
//            postAdapter.submitList(li.toMutableList())
//            Toast.makeText(context,li[it.toInt()-1].fav_count.toString(),Toast.LENGTH_SHORT).show()
            Toast.makeText(context,"coming",Toast.LENGTH_SHORT).show()
        }))
        fragmentPostBinding.postsRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentPostBinding.postsRecyclerView.adapter = postAdapter
        fragmentPostBinding.postsRecyclerView.hasFixedSize()
        postFragmentViewModel.allPosts()
//        postFragmentViewModel.allpost.observe(viewLifecycleOwner, Observer {
//            postAdapter.submitList(it.toMutableList())
//        })

        return fragmentPostBinding.root
    }
}