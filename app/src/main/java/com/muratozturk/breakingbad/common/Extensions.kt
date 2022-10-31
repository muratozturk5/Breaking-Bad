package com.muratozturk.breakingbad.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.muratozturk.breakingbad.R

fun Context.circularProgressDrawable(): Drawable {
    return CircularProgressDrawable(this).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}

fun ImageView.glideImage(url: String) {

    Glide.with(this.context)
        .load(url)
        .override(500, 500) //1
        .diskCacheStrategy(DiskCacheStrategy.DATA) //6
        .placeholder(this.context.circularProgressDrawable())
        .error(R.drawable.ic_baseline_no_photography_24)
        .into(this)
}