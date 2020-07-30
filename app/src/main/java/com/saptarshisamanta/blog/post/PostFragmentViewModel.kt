package com.saptarshisamanta.blog.post

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide

class PostFragmentViewModel :ViewModel(){

}
@BindingAdapter("android:imageUrl")
fun bindImage(imageView: ImageView,imageUrl:String){
    Glide.with(imageView.context)
        .load(imageUrl)
        .into(imageView)
}