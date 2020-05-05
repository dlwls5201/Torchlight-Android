package com.mashup.torchlight.ui.notifications

import android.os.Bundle
import com.mashup.base.baseview.BaseFragment
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentNotificationsBinding

class NotificationsFragment :
    BaseFragment<FragmentNotificationsBinding>(R.layout.fragment_notifications) {

    companion object {
        fun newInstance() = NotificationsFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
