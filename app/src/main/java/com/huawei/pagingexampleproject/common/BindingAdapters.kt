package com.huawei.pagingexampleproject.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Oguz Sahin on 11/11/2021.
 */

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url.isNullOrEmpty()) return
    Glide.with(this).load(url).into(this)
}
