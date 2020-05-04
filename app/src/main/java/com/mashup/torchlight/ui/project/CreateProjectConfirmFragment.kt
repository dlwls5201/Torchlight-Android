package com.mashup.torchlight.ui.project

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectConfirmBinding

class CreateProjectConfirmFragment :
    ProjectBaseFragment<FragmentCreateProjectConfirmBinding>(R.layout.fragment_create_project_confirm) {

    companion object {

        fun newInstance() = CreateProjectConfirmFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initObserve()
        initButton()
    }

    override fun initData() {
        binding.model = projectVM.resultProjectModel

        val selectedCategorises = projectVM.resultProjectModel.categories
        binding.listSelectedCategory.setItemList(selectedCategorises)
    }

    private fun initObserve() {
        projectVM.complete.observe(viewLifecycleOwner, Observer {
            with(requireActivity()) {
                setResult(Activity.RESULT_OK)
                finish()
            }
        })
    }

    private fun initButton() {
        binding.btnCreateProjectComplete.setOnClickListener {
            projectVM.addProject()
        }
    }
}
