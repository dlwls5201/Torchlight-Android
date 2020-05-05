package com.mashup.base.sample.simple

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.mashup.base.BR
import com.mashup.base.R
import com.mashup.base.baseview.BaseFragment
import com.mashup.base.databinding.FragmentRecyclerViewBinding
import com.mashup.base.databinding.ItemSampleBinding
import com.mashup.base.ext.toast
import com.mashup.base.sample.data.SampleData
import com.mashup.base.simplerecyclerview.SimpleRecyclerViewAdapter
import com.mashup.base.simplerecyclerview.SimpleViewHolder

class SimpleRecyclerViewFragment :
    BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    companion object {

        fun newInstance() = SimpleRecyclerViewFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.listSample) {
            adapter = object : SimpleRecyclerViewAdapter<String, ItemSampleBinding>(
                R.layout.item_sample,
                BR.model
            ) {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): SimpleViewHolder<ItemSampleBinding> {
                    return super.onCreateViewHolder(parent, viewType).apply {
                        itemView.setOnClickListener {
                            val data = getItem(adapterPosition)
                            this@SimpleRecyclerViewFragment.requireContext().toast(data)
                        }
                    }
                }
            }.apply {
                replaceAll(SampleData.get("SimpleRecyclerViewFragment"))
            }
        }
    }
}