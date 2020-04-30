package com.mashup.torchlight.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProfileConfirmBinding
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData
import kotlinx.android.synthetic.main.fragment_create_profile_mandatory_info.*

class EditProfileMandatoryInfoFragment
    : ProfileBaseFragment<FragmentCreateProfileConfirmBinding>(R.layout.fragment_create_profile_mandatory_info) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val dataList = ArrayList<ItemSelectorData>()
        dataList.add(ItemSelectorData(0, "Te111st", null))
        dataList.add(ItemSelectorData(1, "Wow1", null))
        dataList.add(ItemSelectorData(2, "Wow2", null))
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
        selector_profile_job.setItemList(dataList)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(
            movePageListener: CreateProfileActivity.IMovePageListener? = null
        ): EditProfileMandatoryInfoFragment {
            val fragment = EditProfileMandatoryInfoFragment()
            fragment.movePage = movePageListener
            return fragment
        }
    }
}
