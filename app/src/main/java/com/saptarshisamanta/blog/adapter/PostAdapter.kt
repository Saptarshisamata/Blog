package com.saptarshisamanta.blog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.saptarshisamanta.blog.data.Post
import com.saptarshisamanta.blog.databinding.PostBinding

class PostAdapter : ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.postViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class PostViewHolder private constructor(val postBinding: PostBinding) : RecyclerView.ViewHolder(postBinding.root) {
        fun bind(
            post: Post
        ) {
            postBinding.post = post
        }
        companion object {
            fun postViewHolder(parent: ViewGroup): PostViewHolder {
                val postBinding: PostBinding =
                    PostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return PostViewHolder(postBinding)
            }
        }
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