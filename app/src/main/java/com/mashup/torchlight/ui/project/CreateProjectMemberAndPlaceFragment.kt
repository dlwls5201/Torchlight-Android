package com.mashup.torchlight.ui.project

import android.os.Bundle
import com.mashup.base.ext.toast
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectMemberAndPlaceBinding
import com.mashup.torchlight.ui.project.bottomsheet.RequiredMemberBottomSheetDialog
import com.mashup.torchlight.ui.project.model.ProjectModel
import com.mashup.torchlight.ui.project.viewmodel.ProjectMemberViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateProjectMemberAndPlaceFragment :
    ProjectBaseFragment<FragmentCreateProjectMemberAndPlaceBinding>(R.layout.fragment_create_project_member_and_place) {

    companion object {

        fun newInstance() = CreateProjectMemberAndPlaceFragment()
    }

    private val projectMemberVM: ProjectMemberViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.memberVM = projectMemberVM

        initButton()
        initJobView()
    }

    override fun initData() {
        projectMemberVM.initMember(
            planer = projectVM.resultProjectModel.planer,
            client = projectVM.resultProjectModel.client,
            server = projectVM.resultProjectModel.server,
            designer = projectVM.resultProjectModel.designer
        )
    }

    private fun initButton() {
        binding.tvCreateProjectMemberAndPlaceArea.setOnClickListener {
            requireContext().toast("준비중입니다.")
        }

        binding.btnCreateProjectNext.setOnClickListener {
            with(projectVM) {
                setMembers(
                    planer = projectMemberVM.planer.value!!,
                    client = projectMemberVM.client.value!!,
                    server = projectMemberVM.server.value!!,
                    designer = projectMemberVM.designer.value!!
                )
                setArea(binding.tvCreateProjectMemberAndPlaceArea.text.toString())
                goNextStep()
            }
        }
    }

    private fun initJobView() {
        with(binding) {
            viewItemNeedJobPlaner.btnItemNeedJob.setOnClickListener {
                showBottomSheet(projectMemberVM.planer.value)
            }
            viewItemNeedJobClient.btnItemNeedJob.setOnClickListener {
                showBottomSheet(projectMemberVM.client.value)
            }
            viewItemNeedJobServer.btnItemNeedJob.setOnClickListener {
                showBottomSheet(projectMemberVM.server.value)
            }
            viewItemNeedJobDesigner.btnItemNeedJob.setOnClickListener {
                showBottomSheet(projectMemberVM.designer.value)
            }
        }
    }

    private fun showBottomSheet(member: ProjectModel.Member?) {
        if (member == null) return

        val bottomSheetDialog = RequiredMemberBottomSheetDialog(projectMemberVM, member)
        bottomSheetDialog.show(requireFragmentManager(), bottomSheetDialog.tag)
    }
}
