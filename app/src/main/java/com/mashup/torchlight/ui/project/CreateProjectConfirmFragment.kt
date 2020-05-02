package com.mashup.torchlight.ui.project

import android.app.Activity
import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectConfirmBinding
import kotlinx.android.synthetic.main.view_create_category_button_complete.*

class CreateProjectConfirmFragment :
    ProjectBaseFragment<FragmentCreateProjectConfirmBinding>(R.layout.fragment_create_project_confirm) {

    companion object {

        fun newInstance() = CreateProjectConfirmFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initButton()
    }

    override fun initData() {
        binding.model = projectVM.resultProjectModel

        val selectedCategorises = projectVM.resultProjectModel.categories
        binding.listSelectedCategory.setItemList(selectedCategorises)
    }

    private fun initButton() {
        btnCreateProjectComplete.setOnClickListener {
            with(requireActivity()) {
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }
}
