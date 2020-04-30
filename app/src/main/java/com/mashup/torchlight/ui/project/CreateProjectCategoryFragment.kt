package com.mashup.torchlight.ui.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectCategoryBinding
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData
import kotlinx.android.synthetic.main.fragment_create_project_category.*

class CreateProjectCategoryFragment :
    ProjectBaseFragment<FragmentCreateProjectCategoryBinding>(R.layout.fragment_create_project_category) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val dataList = ArrayList<ItemSelectorData>()
        dataList.add(ItemSelectorData(0, "Te111st", null))
        dataList.add(ItemSelectorData(1, "Wow1", null))
        dataList.add(ItemSelectorData(2, "Wow2", null))
        selector_project_selelct_category.setItemList(dataList)
        dataList.add(ItemSelectorData(3, "Wow3", null))
        dataList.add(ItemSelectorData(4, "Wow4", null))
        dataList.add(ItemSelectorData(5, "Wo5w", null))
        dataList.add(ItemSelectorData(6, "Wo5w", null))
        dataList.add(ItemSelectorData(7, "Wo5w", null))
        dataList.add(ItemSelectorData(8, "Wo5w", null))
        dataList.add(ItemSelectorData(9, "Wo5w", null))
        dataList.add(ItemSelectorData(10, "o5w", null))
        dataList.add(ItemSelectorData(11, "o5w", null))
        dataList.add(ItemSelectorData(12, "W5w", null))
        selector_project_category.setItemList(dataList)

    }

}
