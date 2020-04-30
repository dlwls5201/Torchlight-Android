package com.mashup.torchlight.ui.myproject

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.base.BaseFragment
import com.mashup.torchlight.databinding.FragmentMyProjectBinding

class MyProjectFragment : BaseFragment<FragmentMyProjectBinding>(R.layout.fragment_my_project) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance() = MyProjectFragment()
    }

}
