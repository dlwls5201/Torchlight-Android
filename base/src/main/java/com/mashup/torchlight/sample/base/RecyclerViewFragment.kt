package com.mashup.torchlight.sample.base

import android.os.Bundle
import android.view.View
import com.mashup.torchlight.R
import com.mashup.torchlight.base.BaseFragment
import com.mashup.torchlight.databinding.FragmentRecyclerViewBinding
import com.mashup.torchlight.ext.toast
import com.mashup.torchlight.sample.data.SampleData

class RecyclerViewFragment :
    BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    companion object {

        fun newInstance() = RecyclerViewFragment()
    }

    private val recyclerViewAdapter by lazy {
        RecyclerViewAdapter().apply {
            onItemClickListener = object :
                RecyclerViewAdapter.OnItemClickListener {
                override fun onItemClick(data: String) {
                    this@RecyclerViewFragment.requireContext().toast(data)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.listSample) {
            adapter = recyclerViewAdapter
        }

        recyclerViewAdapter.replaceAll(SampleData.get("RecyclerViewFragment"))
    }
}