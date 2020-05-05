package com.mashup.torchlight.ui.project

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.mashup.base.ext.toast
import com.mashup.base.util.DLog
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectPlatformBinding
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData
import com.mashup.torchlight.ui.project.model.ProjectModel
import kotlinx.android.synthetic.main.fragment_create_project_platform.*

class CreateProjectPlatformFragment :
    ProjectBaseFragment<FragmentCreateProjectPlatformBinding>(R.layout.fragment_create_project_platform) {

    companion object {

        fun newInstance() = CreateProjectPlatformFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initButton()
        initPlatformItemList()
        initDesktopItemList()
        initFieldItemList()
    }

    override fun initData() {
        DLog.d("resultProjectModel : ${projectVM.resultProjectModel}")

        with(projectVM.resultProjectModel) {
            platform?.let {
                selector_project_platform.setSelectedItemById(it.ordinal)
            }
            desktop?.let {
                selector_project_desktop.setSelectedItemById(it.ordinal)
            }
            field?.let {
                selector_project_field.setSelectedItemById(it.ordinal)
            }
        }
    }

    private fun initButton() {

        binding.btnCreateProjectNext.setOnClickListener {
            val platformItems = selector_project_platform.getSelectedItemList()

            val desktopItems = selector_project_desktop.getSelectedItemList()

            val fieldItems = selector_project_field.getSelectedItemList()

            if (platformItems.isNotEmpty() && desktopItems.isNotEmpty() && fieldItems.isNotEmpty()) {
                projectVM.setPlatform(
                    platformItems.first().name,
                    desktopItems.first().name,
                    fieldItems.first().name
                )
                projectVM.goNextStep()
            } else {
                requireContext().toast("플랫폼을 설정해주세요.")
            }
        }
    }

    private fun initPlatformItemList() {
        selector_project_platform.setItemList(
            listOf(
                ItemSelectorData(
                    ProjectModel.PlatformType.IOS.ordinal,
                    ProjectModel.PlatformType.IOS.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_ios)
                ),
                ItemSelectorData(
                    ProjectModel.PlatformType.ANDROID.ordinal,
                    ProjectModel.PlatformType.ANDROID.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_android)
                ),
                ItemSelectorData(
                    ProjectModel.PlatformType.WEB.ordinal,
                    ProjectModel.PlatformType.WEB.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_web)
                )
            )
        )
    }

    private fun initDesktopItemList() {
        selector_project_desktop.setItemList(
            listOf(
                ItemSelectorData(
                    ProjectModel.DesktopType.MACOS.ordinal,
                    ProjectModel.DesktopType.MACOS.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_mac_os)
                ),
                ItemSelectorData(
                    ProjectModel.DesktopType.WINDOWS.ordinal,
                    ProjectModel.DesktopType.WINDOWS.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_window)
                ),
                ItemSelectorData(
                    ProjectModel.DesktopType.LiNUX.ordinal,
                    ProjectModel.DesktopType.LiNUX.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_linux)
                )
            )
        )
    }

    private fun initFieldItemList() {
        selector_project_field.setItemList(
            listOf(
                ItemSelectorData(
                    ProjectModel.FieldType.GAME.ordinal,
                    ProjectModel.FieldType.GAME.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_game)
                ),
                ItemSelectorData(
                    ProjectModel.FieldType.BLOCKCHAIN.ordinal,
                    ProjectModel.FieldType.BLOCKCHAIN.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_blockchain)
                ),
                ItemSelectorData(
                    ProjectModel.FieldType.AI.ordinal,
                    ProjectModel.FieldType.AI.name,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_ai)
                )
            )
        )
    }
}
