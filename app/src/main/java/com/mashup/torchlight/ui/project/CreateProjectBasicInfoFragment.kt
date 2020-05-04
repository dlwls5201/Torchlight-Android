package com.mashup.torchlight.ui.project

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectBasicInfoBinding
import com.mashup.torchlight.ext.toast
import kotlinx.android.synthetic.main.fragment_create_project_basic_info.*

class CreateProjectBasicInfoFragment :
    ProjectBaseFragment<FragmentCreateProjectBasicInfoBinding>(R.layout.fragment_create_project_basic_info) {

    companion object {

        fun newInstance() = CreateProjectBasicInfoFragment()
    }

    override fun initData() {
        etCreateProjectBasicInfoTitle.setText(projectVM.resultProjectModel.title)
        etCreateProjectBasicInfoSummary.setText(projectVM.resultProjectModel.summary)
        etCreateProjectBasicInfoDescription.setText(projectVM.resultProjectModel.description)
        etCreateProjectBasicInfoPhone.setText(projectVM.resultProjectModel.phone)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnCreateProjectNext.setOnClickListener {
            val title = etCreateProjectBasicInfoTitle.text.toString()
            val summary = etCreateProjectBasicInfoSummary.text.toString()
            val description = etCreateProjectBasicInfoDescription.text.toString()
            val phone = etCreateProjectBasicInfoPhone.text.toString()

            if (title.isEmpty() || summary.isEmpty() || description.isEmpty()) {
                requireContext().toast("기본 정보를 입력해 주세요.")
            } else {
                projectVM.setBasicInfo(title, summary, description, phone)
                projectVM.goNextStep()
            }
        }
    }

}


