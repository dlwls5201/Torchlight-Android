package com.mashup.torchlight.ui.home

import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.mashup.torchlight.R
import com.mashup.torchlight.base.BaseFragment
import com.mashup.torchlight.databinding.FragmentHomeBinding
import com.mashup.torchlight.databinding.ItemProjectBinding
import com.mashup.torchlight.ext.toast
import com.mashup.torchlight.simplerecyclerview.SimpleRecyclerViewAdapter
import com.mashup.torchlight.simplerecyclerview.SimpleViewHolder
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData
import com.mashup.torchlight.ui.project.model.ProjectModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initButton()
        setUpRecycleView()
    }

    private fun initButton() {
        btnFragmentHomeSearch.setOnClickListener {
            requireContext().toast("준비중입니다.")
        }
    }

    private fun setUpRecycleView() {
        val testAdapter = object : SimpleRecyclerViewAdapter<ProjectModel, ItemProjectBinding>(
            layoutRes = R.layout.item_project,
            bindingVariableId = BR.model
        ) {
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): SimpleViewHolder<ItemProjectBinding> {
                return super.onCreateViewHolder(parent, viewType).apply {

                }
            }
        }

        with(binding.rvHomeProject) {
            adapter = testAdapter
        }

        val testSample = listOf(
            ProjectModel(
                passion = ProjectModel.Passion.ONE,
                platform = ProjectModel.PlatformType.ANDROID,
                desktop = ProjectModel.DesktopType.MACOS,
                field = ProjectModel.FieldType.AI,
                categories = listOf(
                    ItemSelectorData(0, "취미1", null),
                    ItemSelectorData(0, "취미2", null),
                    ItemSelectorData(0, "취미3", null)
                ),
                scale = ProjectModel.ProjectScale.BIG,
                planer = ProjectModel.Member.PLANNER(1, 3),
                client = ProjectModel.Member.CLIENT(1, 3),
                server = ProjectModel.Member.SERVER(1, 3),
                designer = ProjectModel.Member.DESIGNER(2, 3),
                area = "동작구",
                title = "Torchlight 안드로이드",
                summary = "안드로이드 개발을 해봐요",
                description = "설명은 생략한다.",
                phone = "01077255201"
            ),
            ProjectModel(
                passion = ProjectModel.Passion.TWO,
                platform = ProjectModel.PlatformType.IOS,
                desktop = ProjectModel.DesktopType.LiNUX,
                field = ProjectModel.FieldType.BLOCKCHAIN,
                categories = listOf(ItemSelectorData(0, "IOS", null)),
                scale = ProjectModel.ProjectScale.BIG,
                planer = ProjectModel.Member.PLANNER(0, 3),
                client = ProjectModel.Member.CLIENT(0, 3),
                area = "동작구",
                title = "Torchlight 안드로이드와 IOS",
                summary = "사이드 프로젝트 모집 플랫폼 Torchlight의\n" +
                        "iOS 앱 개발을 위한 프로젝트입니다.",
                description = "설명은 생략한다.",
                phone = "01077255201"
            ),
            ProjectModel(
                passion = ProjectModel.Passion.THREE,
                platform = ProjectModel.PlatformType.WEB,
                desktop = ProjectModel.DesktopType.MACOS,
                field = ProjectModel.FieldType.GAME,
                categories = listOf(ItemSelectorData(0, "취미", null)),
                scale = ProjectModel.ProjectScale.BIG,
                planer = ProjectModel.Member.PLANNER(2, 3),
                client = ProjectModel.Member.CLIENT(2, 3),
                server = ProjectModel.Member.SERVER(2, 3),
                designer = ProjectModel.Member.DESIGNER(2, 3),
                area = "동작구",
                title = "웹 안드로이드",
                summary = "웹 개발을 해봐요",
                description = "설명은 생략한다.",
                phone = "01077255201"
            )
        )

        testAdapter.replaceAll(testSample)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}
