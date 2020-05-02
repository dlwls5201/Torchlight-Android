package com.mashup.torchlight.bindingadapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("setImageUrl")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .placeholder(ColorDrawable(Color.GRAY))
        .error(ColorDrawable(Color.DKGRAY))
        .into(this)
}

@BindingAdapter("setCircleImageUrl")
fun ImageView.setCircleImageUrl(url: String?) {

    val options = RequestOptions().apply {
        circleCrop()
    }

    Glide.with(context)
        .load(url)
        .apply(options)
        .placeholder(ColorDrawable(Color.GRAY))
        .error(ColorDrawable(Color.DKGRAY))
        .into(this)
}

@BindingAdapter("imgRes")
fun ImageView.setImageRes(@DrawableRes resId: Int) {
    setImageResource(resId)
}

@BindingAdapter("imgDrawable")
fun ImageView.setImageDrawable(drawable: Drawable) {
    setImageDrawable(drawable)
}

@BindingAdapter("setHtmlText")
fun TextView.setHtmlText(htmlString: String?) {
    if (htmlString.isNullOrEmpty()) return

    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(htmlString, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(htmlString)
    }
}

@BindingAdapter("setHtmlText")
fun TextView.setHtmlText(@StringRes resId: Int) {

    val htmlString = resources.getString(resId)

    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(htmlString, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(htmlString)
    }
}


