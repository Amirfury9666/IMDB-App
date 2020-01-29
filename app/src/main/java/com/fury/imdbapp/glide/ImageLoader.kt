package com.fury.imdbapp.glide

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.fury.imdbapp.R

object ImageLoader{
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadUserProfileImage(imageView: ImageView, url : String?){
        url?.let {
            Glide.with(imageView.context).load(it).placeholder(R.drawable.ic_photo).into(imageView)
        }
    }
}