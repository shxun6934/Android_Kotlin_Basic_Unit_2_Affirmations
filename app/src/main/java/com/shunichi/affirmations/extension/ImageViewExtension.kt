package com.shunichi.affirmations.extension

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("srcCompact")
fun ImageView.srcCompat(drawable: Drawable) {
    this.setImageDrawable(drawable)
}