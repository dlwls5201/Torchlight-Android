package com.mashup.torchlight.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mashup.torchlight.R
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorView
import com.mashup.torchlight.ui.project.model.ProjectModel

@BindingAdapter("setJobImage")
fun ImageView.setJobImage(member: ProjectModel.Member?) {
    if (member == null) return

    val id = when (member) {
        is ProjectModel.Member.PLANNER -> R.drawable.ic_project_manager
        is ProjectModel.Member.CLIENT -> R.drawable.ic_client
        is ProjectModel.Member.SERVER -> R.drawable.ic_server
        is ProjectModel.Member.DESIGNER -> R.drawable.ic_designer
    }
    setImageResource(id)
}

@BindingAdapter("setPlatformImage")
fun ImageView.setJobImage(type: ProjectModel.PlatformType?) {
    if (type == null) return

    val id = when (type) {
        ProjectModel.PlatformType.ANDROID -> R.drawable.ic_android
        ProjectModel.PlatformType.IOS -> R.drawable.ic_ios
        ProjectModel.PlatformType.WEB -> R.drawable.ic_web
    }
    setImageResource(id)
}

@BindingAdapter("setItemList")
fun ItemSelectorView.setItemList(list: List<ItemSelectorView>) {
    setItemList(list)
}
