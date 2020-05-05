package com.mashup.base.sample

import android.os.Bundle
import android.view.View
import com.mashup.base.R
import com.mashup.base.baseview.BaseFragment
import com.mashup.base.databinding.FragmentSampleBinding
import com.mashup.base.ext.alert
import com.mashup.base.ext.toast
import com.mashup.base.listener.OnSingleClickListener

class SampleFragment : BaseFragment<FragmentSampleBinding>(R.layout.fragment_sample) {

    companion object {

        fun newInstance() = SampleFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnAlert.setOnClickListener {
                requireContext().alert(title = "BlackJin", message = "Welcome to my blog") {
                    positiveButton("ok") {
                        requireContext().toast("click the positive button")
                        //auto dismiss
                    }

                    negativeButton("cancel") {
                        //auto dismiss
                    }
                }.show()
            }

            var count = 0
            btnSingleClick.setOnClickListener(object : OnSingleClickListener(3000) {
                override fun onSingleClick(view: View) {
                    btnSingleClick.text = "${count++}"
                }
            })

            btnRecyclerView.setOnClickListener {
                (requireActivity() as SampleActivity).goToRecyclerViewFragment()
            }

            btnSimpleRecyclerView.setOnClickListener {
                (requireActivity() as SampleActivity).goToSimpleRecyclerViewFragment()
            }

            btnLiveRecyclerView.setOnClickListener {
                (requireActivity() as SampleActivity).goToLiveRecyclerViewFragment()
            }
        }
    }
}