package com.mashup.torchlight.ui.project

import android.os.Bundle
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectCategoryBinding
import com.mashup.torchlight.ext.toast
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData
import com.mashup.torchlight.util.DLog
import kotlinx.android.synthetic.main.fragment_create_project_category.*
import kotlinx.android.synthetic.main.view_create_category_button.*

class CreateProjectCategoryFragment :
    ProjectBaseFragment<FragmentCreateProjectCategoryBinding>(R.layout.fragment_create_project_category) {

    companion object {

        fun newInstance() = CreateProjectCategoryFragment()
    }

    private val items = listOf(
        ItemSelectorData(0, "건강 및 피트니스", null),
        ItemSelectorData(1, "교육", null),
        ItemSelectorData(2, "금융", null),
        ItemSelectorData(3, "날씨", null),
        ItemSelectorData(4, "네비게이션", null),
        ItemSelectorData(5, "뉴스", null),
        ItemSelectorData(6, "도서", null),
        ItemSelectorData(7, "라이프스타일", null),
        ItemSelectorData(8, "비즈니스", null),
        ItemSelectorData(9, "사진 및 비디오", null),
        ItemSelectorData(10, "생산성", null),
        ItemSelectorData(11, "소셜 네트워킹", null),
        ItemSelectorData(12, "쇼핑", null),
        ItemSelectorData(13, "스포츠", null),
        ItemSelectorData(14, "어린이", null),
        ItemSelectorData(15, "엔터테이먼트", null),
        ItemSelectorData(16, "여행", null),
        ItemSelectorData(17, "유틸리티", null),
        ItemSelectorData(18, "음식 및 음료", null),
        ItemSelectorData(19, "음악", null),
        ItemSelectorData(20, "의학", null),
        ItemSelectorData(21, "잡지 및 신문", null),
        ItemSelectorData(22, "참고", null),
        ItemSelectorData(23, "AR", null)
    )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAllCategory()
        initButton()
        setCallbackAdapter()
    }

    override fun initData() {
        DLog.d("categories : ${projectVM.resultProjectModel.categories}")
        val selectedCategorises = projectVM.resultProjectModel.categories
        list_all_category.setSelectCategories(selectedCategorises)
        list_selected_category.setItemList(selectedCategorises)
    }

    private fun initAllCategory() {
        list_all_category.setItemList(items)
    }

    private fun initButton() {
        btnCreateProjectNext.setOnClickListener {
            val selectedCategory = list_all_category.getSelectedItemList()
            if (selectedCategory.isEmpty()) {
                requireContext().toast("적어도 한개 카테고리를 설정해주세요.")
            } else {
                projectVM.setCategory(selectedCategory)
                projectVM.goNextStep()
            }
        }
    }

    private fun setCallbackAdapter() {
        list_all_category.setItemCallback {
            if (it.isSelected) {
                addItemSelectedList(it)
            } else {
                removeItemSelectedList(it)
            }
        }
        list_selected_category.setRemoveItemCallback {
            list_all_category.replaceItem(it.copy(isSelected = false))
        }
    }

    private fun addItemSelectedList(item: ItemSelectorData) {
        list_selected_category.addItem(item)
    }

    private fun removeItemSelectedList(item: ItemSelectorData) {
        list_selected_category.removeItemById(item.id)
    }
}
