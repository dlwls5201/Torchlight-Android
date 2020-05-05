package com.mashup.base.sample.live

import android.os.Bundle
import android.view.View
import com.mashup.base.R
import com.mashup.base.baseview.BaseFragment
import com.mashup.base.databinding.FragmentRecyclerViewBinding
import com.mashup.base.ext.toast
import com.mashup.base.liverecyclerview.bindData
import com.mashup.base.sample.data.SampleData

class LiveRecyclerViewFragment :
    BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    companion object {

        fun newInstance() = LiveRecyclerViewFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listSample.bindData(
            SampleData.get("LiveRecyclerViewFragment"),
            R.layout.item_sample,
            viewLifecycleOwner
        ) {
            requireContext().toast(it)
        }
    }
}