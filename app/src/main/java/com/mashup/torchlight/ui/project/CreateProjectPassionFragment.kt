package com.mashup.torchlight.ui.project

import android.graphics.Color
import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectPassionBinding
import com.mashup.torchlight.ui.customview.CustomThreeBtn
import com.mashup.torchlight.ui.project.model.ProjectModel
import kotlinx.android.synthetic.main.fragment_create_project_passion.*
import kotlinx.android.synthetic.main.view_create_category_button.*

class CreateProjectPassionFragment :
    ProjectBaseFragment<FragmentCreateProjectPassionBinding>(R.layout.fragment_create_project_passion) {

    companion object {

        fun newInstance() = CreateProjectPassionFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initSelectThreeButton()
        initButton()
    }

    override fun initData() {
        val checkId = when (projectVM.resultProjectModel.passion) {
            ProjectModel.Passion.ONE -> 0
            ProjectModel.Passion.TWO -> 1
            ProjectModel.Passion.THREE -> 2
        }
        btnSelectThree.setCheckId(checkId)
        setPassionText()
    }

    private fun initSelectThreeButton() {
        btnSelectThree.setText("1단계", "2단계", "3단계")
        btnSelectThree.setOnButtonClick(object : CustomThreeBtn.OnButtonClick {
            override fun onSelect(index: Int) {
                btnSelectThree.setCheckId(index)
                setPassionText()

                val color = when (index) {
                    0 -> "#9988ff"
                    1 -> "#00ff00"
                    2 -> "#606060"
                    else -> "#000000"
                }

                ivCreateProjectPassion.setBackgroundColor(Color.parseColor(color))

            }
        })
    }

    private fun setPassionText() {
        val passion = when (btnSelectThree.getCheckId()) {
            0 -> "사이드 프로젝트를 한 번 경험해보고 싶어요."
            1 -> "배포를 경험해보고 싶어요."
            2 -> "창업으로 발전시키고 싶어요."
            else -> ""
        }
        tvCreateProjectPassion.text = passion
    }

    private fun initButton() {
        btnCreateProjectNext.setOnClickListener {
            if (btnSelectThree.getCheckId() > -1) {
                val passion = when (btnSelectThree.getCheckId()) {
                    0 -> ProjectModel.Passion.ONE
                    1 -> ProjectModel.Passion.TWO
                    2 -> ProjectModel.Passion.THREE
                    else -> ProjectModel.Passion.ONE
                }
                projectVM.setPassion(passion)
                projectVM.goNextStep()
            }
        }
    }
}
