package com.mashup.torchlight.ui.customview.itemselectorview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mashup.base.util.DLog
import com.mashup.torchlight.R

class ItemSelectorAdapter(private var style: ItemSelectorStyle) :
    RecyclerView.Adapter<ItemSelectorVH>() {
    val itemList: ArrayList<ItemSelectorData> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSelectorVH {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.view_item_selector_item, parent, false)
        return ItemSelectorVH(
            view
        )
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ItemSelectorVH, position: Int) {
        holder.bind(
            itemList[position],
            style,
            ::toggleItemSelectedById,
            ::removeItemById,
            removeItemCallback
        )
    }

    fun getSelectedItemCount(): Int = itemList.count { x -> x.isSelected }

    fun getSelectedItems(): ArrayList<ItemSelectorData> =
        itemList.filter { x -> x.isSelected } as ArrayList<ItemSelectorData>

    fun setSelectCategories(categories: List<ItemSelectorData>) {
        itemList.mapIndexed { index, item ->

            var isSelected = false
            for (category in categories) {
                if (item.name == category.name) {
                    isSelected = true
                    break
                }
            }
            DLog.d("isSelected : $isSelected")
            if (isSelected) {
                itemList[index] = item.copy(isSelected = true)
            }
        }
        DLog.d("itemList : $itemList")
        notifyDataSetChanged()
    }

    fun setItemList(dataList: List<ItemSelectorData>) {
        itemList.clear()
        for (data: ItemSelectorData in dataList) {
            itemList.add(data)
        }
        notifyDataSetChanged()
    }

    fun addItem(data: ItemSelectorData) {
        itemList.add(data)
        notifyItemInserted(itemList.size - 1)
    }

    fun addItem(idx: Int, data: ItemSelectorData) {
        itemList.add(idx, data)
        notifyItemInserted(idx)
    }

    fun removeItem(idx: Int) {
        itemList.removeAt(idx)
        notifyItemRemoved(idx)
    }

    fun removeItem(data: ItemSelectorData) {
        val idx = itemList.indexOf(data)
        removeItem(idx)
    }

    fun removeItemById(id: Int) {
        val idx = itemList.indexOfFirst { x -> x.id == id }
        removeItem(idx)
    }

    fun replaceItem(data: ItemSelectorData) {
        val idx = itemList.indexOfFirst { x -> x.id == data.id }
        itemList[idx] = data
        notifyItemChanged(idx)
    }

    fun clearItems() {
        itemList.clear()
        notifyDataSetChanged()
    }

    fun setItemSelectedById(id: Int, selected: Boolean) {
        val idx = itemList.indexOfFirst { x -> x.id == id }
        setItemSelected(idx, selected)
    }

    private fun setItemSelected(idx: Int, selected: Boolean) {
        if (selected) {
            if (style.maxSelectedCnt > 0
                && getSelectedItemCount() >= style.maxSelectedCnt
            ) {
                return
            }

            if (!style.isMultiSelectable) {
                for (data: ItemSelectorData in itemList) {
                    data.isSelected = false
                }
            }

            itemList[idx].isSelected = true

            if (!style.isMultiSelectable) {
                notifyItemRangeChanged(0, itemCount)
            } else {
                notifyItemChanged(idx)
            }
        } else {
            if (style.isAllDeselectable && getSelectedItemCount() == 0) {
                return
            } else {
                itemList[idx].isSelected = false
                notifyItemChanged(idx)
            }
        }

        itemCallback?.invoke(itemList[idx])
    }

    fun toggleItemSelected(idx: Int) {
        val item = itemList[idx]
        setItemSelected(idx, !item.isSelected)
    }

    fun toggleItemSelectedById(id: Int) {
        val idx = itemList.indexOfFirst { x -> x.id == id }
        toggleItemSelected(idx)
    }

    var removeItemCallback: ((data: ItemSelectorData) -> Unit)? = null

    var itemCallback: ((data: ItemSelectorData) -> Unit)? = null
}