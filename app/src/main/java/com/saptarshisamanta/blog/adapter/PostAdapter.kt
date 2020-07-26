package com.saptarshisamanta.blog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.saptarshisamanta.blog.R
import com.saptarshisamanta.blog.data.Post
import com.saptarshisamanta.blog.databinding.PostBinding

class PostAdapter : ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        //TODO("Not yet implemented")
        val postBinding:PostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.post,parent,false)
        return PostViewHolder(postBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val post:Post = getItem(position)
        holder.postBinding.post = post
    }

    class PostViewHolder(val postBinding: PostBinding) : RecyclerView.ViewHolder(postBinding.root) {
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        TODO("Not yet implemented")
    }

}