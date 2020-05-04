package com.mashup.torchlight.ui.project

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectRequiredMemberAndPlaceBinding
import com.mashup.torchlight.ext.toast
import com.mashup.torchlight.ui.project.bottomsheet.RequiredMemberBottomSheetDialog
import com.mashup.torchlight.ui.project.model.ProjectModel

class CreateProjectRequiredMemberAndPlaceFragment :
    ProjectBaseFragment<FragmentCreateProjectRequiredMemberAndPlaceBinding>(R.layout.fragment_create_project_required_member_and_place) {

    companion object {

        fun newInstance() = CreateProjectRequiredMemberAndPlaceFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initButton()
        initJobView()
    }

    override fun initData() {
        with(binding) {
            planer = ProjectModel.Member.PLANNER(1, 2)
            client = ProjectModel.Member.CLIENT(1, 2)
            server = ProjectModel.Member.SERVER(1, 2)
            designer = ProjectModel.Member.DESIGNER(1, 2)
        }
    }

    private fun initButton() {
        binding.tvCreateProjectRequiredMemberAndPlaceArea.setOnClickListener {
            requireContext().toast("준비중입니다.")
        }

        binding.btnCreateProjectNext.setOnClickListener {
            projectVM.setMembers(
                ProjectModel.Member.PLANNER(1, 2),
                ProjectModel.Member.CLIENT(1, 2),
                ProjectModel.Member.SERVER(1, 2),
                ProjectModel.Member.DESIGNER(1, 2)
            )
            projectVM.setArea(binding.tvCreateProjectRequiredMemberAndPlaceArea.text.toString())
            projectVM.goNextStep()
        }
    }

    private fun initJobView() {
        with(binding) {
            viewItemNeedJobPlaner.btnItemNeedJob.setOnClickListener {
                showBottomSheet()
            }
            viewItemNeedJobClient.btnItemNeedJob.setOnClickListener {
                showBottomSheet()
            }
            viewItemNeedJobServer.btnItemNeedJob.setOnClickListener {
                showBottomSheet()
            }
            viewItemNeedJobDesigner.btnItemNeedJob.setOnClickListener {
                showBottomSheet()
            }
        }
    }

    private fun showBottomSheet() {
        val bottomSheetDialog = RequiredMemberBottomSheetDialog()
        bottomSheetDialog.show(requireFragmentManager(), bottomSheetDialog.tag)
    }
}
