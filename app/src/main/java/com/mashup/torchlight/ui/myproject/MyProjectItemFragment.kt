package com.mashup.torchlight.ui.myproject

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.base.BaseFragment
import com.mashup.torchlight.databinding.FragmentMyProjectItemBinding
import com.mashup.torchlight.databinding.ItemProjectBinding
import com.mashup.torchlight.model.ProjectModel
import com.mashup.torchlight.simplerecyclerview.SimpleRecyclerViewAdapter

class MyProjectItemFragment :
    BaseFragment<FragmentMyProjectItemBinding>(R.layout.fragment_my_project_item) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpRecycleView()
    }

    private fun setUpRecycleView() {
        with(binding.rvFragmentMyProject) {
            adapter = object : SimpleRecyclerViewAdapter<ProjectModel, ItemProjectBinding>(
                layoutRes = R.layout.item_project,
                bindingVariableId = com.mashup.torchlight.BR.itemProject
            ) {}

            val items = mutableListOf(
                ProjectModel(
                    name = "name1",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                ),
                ProjectModel(
                    name = "name2",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                ),
                ProjectModel(
                    name = "name3",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                ),
                ProjectModel(
                    name = "name4",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                ),
                ProjectModel(
                    name = "name5",
                    description = "description",
                    recruitmentCnt = 10,
                    tag = listOf()
                )
            )

            (adapter as SimpleRecyclerViewAdapter<Any, *>).run {
                replaceAll(items)
            }
        }
    }

    companion object {
        fun newInstance() = MyProjectItemFragment()
    }
}