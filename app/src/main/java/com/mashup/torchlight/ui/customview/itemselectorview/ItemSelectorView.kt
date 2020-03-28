package com.mashup.torchlight.ui.customview.itemselectorview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.*
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.mashup.torchlight.R
import kotlinx.android.synthetic.main.view_item_selector_item.view.*

class ItemSelectorView: RecyclerView {

    private var displayStyle =
        ItemSelectorStyle()
    private lateinit var itemSelectorAdapter: ItemSelectorAdapter

    constructor(context: Context) : super(context) { init(null) }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { init(attrs) }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) { init(attrs) }

    private fun init(attrs: AttributeSet?) {
        loadAttrs(attrs)

        if (displayStyle.isScrollable) {
            super.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
        } else {
            super.setLayoutManager(FlexboxLayoutManager(context, FlexDirection.ROW, FlexWrap.WRAP))
        }

        // create / set adapter
        itemSelectorAdapter =
            ItemSelectorAdapter(
                displayStyle
            )
        super.setAdapter(itemSelectorAdapter)
    }

    private fun loadAttrs(attrs: AttributeSet?) {
        val attrTypedArr = context.obtainStyledAttributes(attrs, R.styleable.ItemSelectorView)
        val primaryColor = context.resources.getColor(R.color.colorPrimary)
        val whiteColor = Color.WHITE
        val accentColor = context.resources.getColor(R.color.colorAccent)
        with(displayStyle) {
            isMultiSelectable = attrTypedArr.getBoolean(R.styleable.ItemSelectorView_multi_selectable, false)
            isRemovable = attrTypedArr.getBoolean(R.styleable.ItemSelectorView_removable, false)
            isAllDeselectable = attrTypedArr.getBoolean(R.styleable.ItemSelectorView_all_deselectable, false)
            maxSelectedCnt = attrTypedArr.getInt(R.styleable.ItemSelectorView_max_select_count, 0)
            isScrollable = attrTypedArr.getBoolean(R.styleable.ItemSelectorView_scrollable, true)
            displayType = attrTypedArr.getInt(R.styleable.ItemSelectorView_display_type, 1)
            borderThickness = attrTypedArr.getInt(R.styleable.ItemSelectorView_border_thickness, 2)
            radius = attrTypedArr.getDimension(R.styleable.ItemSelectorView_radius, 20f)
            removeBtnSize = attrTypedArr.getDimensionPixelSize(R.styleable.ItemSelectorView_remove_btn_size, 65)
            textSize = attrTypedArr.getDimensionPixelSize(R.styleable.ItemSelectorView_text_size, 20)
            iconSize = attrTypedArr.getDimensionPixelSize(R.styleable.ItemSelectorView_icon_size, 20)
            itemMargin = attrTypedArr.getDimensionPixelSize(R.styleable.ItemSelectorView_item_margin, 30)
            itemPadding = attrTypedArr.getDimensionPixelSize(R.styleable.ItemSelectorView_item_padding, 30)
            selectedColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_selected_color, primaryColor)
            deselectedColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_deselected_color, whiteColor)
            selectedTextColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_selected_text_color, whiteColor)
            deselectedTextColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_deselected_text_color, primaryColor)
            selectedBottomTextColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_selected_bottom_text_color, whiteColor)
            deselectedBottomTextColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_deselected_bottom_text_color, primaryColor)
            selectedIconColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_selected_icon_color, whiteColor)
            deselectedIconColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_deselected_icon_color, primaryColor)
            borderColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_border_color, primaryColor)
            removeBtnBgColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_remove_btn_bg_color, accentColor)
            removeBtnXColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_remove_btn_x_color, whiteColor)
            removeBtnBorderColor = attrTypedArr.getColor(R.styleable.ItemSelectorView_remove_btn_border_color, accentColor)
            removeBtnBorderThickness = attrTypedArr.getInt(R.styleable.ItemSelectorView_remove_btn_border_thickness, 2)
        }
        attrTypedArr.recycle()
    }

    fun setItemList(dataList: List<ItemSelectorData>) =
        itemSelectorAdapter.setItemList(dataList)

    fun addItem(data: ItemSelectorData) =
        itemSelectorAdapter.addItem(data)

    fun addItem(idx: Int, data: ItemSelectorData) =
        itemSelectorAdapter.addItem(idx, data)

    fun removeItem(idx: Int) =
        itemSelectorAdapter.removeItem(idx)

    fun removeItemById(Id: Int) =
        itemSelectorAdapter.removeItemById(id)

    fun clearItems() =
        itemSelectorAdapter.clearItems()

    fun getItemCount(): Int =
        itemSelectorAdapter.itemCount

    fun getSelectedItemCount(): Int =
        itemSelectorAdapter.getSelectedItemCount()

    fun getSelectedItemList(): ArrayList<ItemSelectorData> =
        itemSelectorAdapter.getSelectedItems()

    fun getItemList(): ArrayList<ItemSelectorData> =
        itemSelectorAdapter.itemList

    @Deprecated("Adapter is handled in the view itself!", ReplaceWith("nothing"), DeprecationLevel.HIDDEN)
    override fun setAdapter(adapter: Adapter<*>?) {
        throw UnsupportedOperationException("Adapter is handled in ItemSelectorView itself!")
    }

    @Deprecated("LayoutManager is handled in the view itself!", ReplaceWith("nothing"), DeprecationLevel.HIDDEN)
    override fun setLayoutManager(layout: LayoutManager?) {
        throw UnsupportedOperationException("LayoutManager is handled in ItemSelectorView itself!")
    }

    companion object {
        @BindingAdapter("list")
        @JvmStatic
        fun setList(view: ItemSelectorView, data: List<ItemSelectorData>) =
            view.itemSelectorAdapter.setItemList(data)
    }
}