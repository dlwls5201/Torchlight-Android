package com.mashup.torchlight.ui.project

import android.os.Bundle
import com.mashup.base.ext.toast
import com.mashup.base.util.DLog
import com.mashup.domain.data.Category
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectCategoryBinding
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData
import kotlinx.android.synthetic.main.fragment_create_project_category.*

class CreateProjectCategoryFragment :
    ProjectBaseFragment<FragmentCreateProjectCategoryBinding>(R.layout.fragment_create_project_category) {

    companion object {

        fun newInstance() = CreateProjectCategoryFragment()
    }

    private val items: List<ItemSelectorData> =
        Category.getItems().mapIndexed { index, category ->
            ItemSelectorData(index, category, null)
        }


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
        binding.btnCreateProjectNext.setOnClickListener {
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
