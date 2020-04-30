package com.mashup.torchlight.ui.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectPlatformBinding
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData
import kotlinx.android.synthetic.main.fragment_create_project_platform.*

class CreateProjectPlatformFragment :
    ProjectBaseFragment<FragmentCreateProjectPlatformBinding>(R.layout.fragment_create_project_platform) {

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
        dataList.add(ItemSelectorData(0, "Te111st", activity!!.getDrawable(R.drawable.ic_android)))
        dataList.add(ItemSelectorData(1, "Wow1", activity!!.getDrawable(R.drawable.ic_android)))
        dataList.add(ItemSelectorData(2, "Wow2", activity!!.getDrawable(R.drawable.ic_android)))
        selector_project_desktop.setItemList(dataList)
        selector_project_platform.setItemList(dataList)
        selector_project_field.setItemList(dataList)

    }
}
