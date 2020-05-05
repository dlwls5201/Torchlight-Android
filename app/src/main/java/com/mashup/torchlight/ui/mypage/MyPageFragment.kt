package com.mashup.torchlight.ui.mypage

import android.os.Bundle
import com.mashup.base.baseview.BaseFragment
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentNotificationsBinding

class MyPageFragment :
    BaseFragment<FragmentNotificationsBinding>(R.layout.fragment_my_page) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance() = MyPageFragment()
    }

}
