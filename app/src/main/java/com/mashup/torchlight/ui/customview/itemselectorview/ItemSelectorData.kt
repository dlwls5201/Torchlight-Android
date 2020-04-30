package com.mashup.torchlight.ui.customview.itemselectorview

import android.graphics.drawable.Drawable

data class ItemSelectorData(
    val id: Int,
    var name: String,
    var image: Drawable?,
    var isSelected: Boolean = false
)