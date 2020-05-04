package com.mashup.torchlight.ui.project

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectMemberAndTermBinding
import com.mashup.torchlight.ext.toast
import com.mashup.torchlight.ui.customview.CustomThreeBtn
import com.mashup.torchlight.ui.project.model.ProjectModel
import kotlinx.android.synthetic.main.fragment_create_project_member_and_term.*
import kotlinx.android.synthetic.main.fragment_create_project_passion.btnSelectThree

class CreateProjectMemberAndTermFragment :
    ProjectBaseFragment<FragmentCreateProjectMemberAndTermBinding>(R.layout.fragment_create_project_member_and_term) {

    companion object {

        fun newInstance() = CreateProjectMemberAndTermFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initSelectThreeButton()
        initButton()
    }

    override fun initData() {
        val ordinal = projectVM.resultProjectModel.scale.ordinal
        btnSelectThree.setCheckId(ordinal)

        val startDate = projectVM.resultProjectModel.startDate
        tvCreateProjectMemberAndTermDate.text = startDate

        setTermText()
    }

    private fun initSelectThreeButton() {
        btnSelectThree.setText("소규모", "중규모", "대규모")
        btnSelectThree.setOnButtonClick(object : CustomThreeBtn.OnButtonClick {
            override fun onSelect(index: Int) {
                btnSelectThree.setCheckId(index)
                setTermText()
            }
        })
    }

    private fun setTermText() {
        val term = when (btnSelectThree.getCheckId()) {
            0 -> "1개월 이내로 프로젝트를 진행합니다."
            1 -> "6개월 이내로 프로젝트를 진행합니다."
            2 -> "장시간 프로젝트를 진행합니다."
            else -> ""
        }
        tvCreateProjectMemberAndTermDescription.text = term
    }

    private fun initButton() {
        binding.btnCreateProjectNext.setOnClickListener {
            if (btnSelectThree.getCheckId() > -1) {
                val scale = when (btnSelectThree.getCheckId()) {
                    0 -> ProjectModel.ProjectScale.SMALL
                    1 -> ProjectModel.ProjectScale.MEDIUM
                    2 -> ProjectModel.ProjectScale.BIG
                    else -> ProjectModel.ProjectScale.SMALL
                }
                projectVM.setProjectScale(scale)
                projectVM.setStartDate(tvCreateProjectMemberAndTermDate.text.toString())
                projectVM.goNextStep()
            }
        }

        tvCreateProjectMemberAndTermDate.setOnClickListener {
            requireContext().toast("준비중입니다.")
        }
    }

}
