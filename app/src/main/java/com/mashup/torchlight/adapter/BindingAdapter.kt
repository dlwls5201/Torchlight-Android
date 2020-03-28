package com.mashup.torchlight.adapter

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:src")
fun bindBitmap(view: ImageView, value: Int?) {
    if (value == null)
        Log.e("123", "image Null")
    else
        view.setImageResource(value)
}
