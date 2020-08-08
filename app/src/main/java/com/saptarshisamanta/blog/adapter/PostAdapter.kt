package com.saptarshisamanta.blog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.saptarshisamanta.blog.data.Post
import com.saptarshisamanta.blog.databinding.PostItemBinding

class PostAdapter(var postListener: PostListener) :
    ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.postViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position)!!, postListener)
    }


    class PostViewHolder private constructor(private var postItemBinding: PostItemBinding) :
        RecyclerView.ViewHolder(postItemBinding.root) {
        fun bind(
            post: Post,
            postListener: PostListener
        ) {
            postItemBinding.post = post
            postItemBinding.executePendingBindings()
            postItemBinding.clickListener = postListener
        }

        companion object {
            fun postViewHolder(parent: ViewGroup): PostViewHolder {
                val postBinding =
                    PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return PostViewHolder(postBinding)
            }
        }
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem._id == newItem._id && oldItem.fav_count ==newItem.fav_count
    }

}

class PostListener(var clickListener: (postId: String) -> Unit,var favClickListener:(postID: String) -> Unit) {
    fun onClick(post: Post) = clickListener(post._id)
    fun onFavClick(post: Post) = favClickListener(post._id)
}