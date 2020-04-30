package com.mashup.torchlight.model

import com.mashup.torchlight.R


data class CreateProjectModel(
    var title: String = "프로젝트 만들기",
    var image: Int = R.drawable.ic_arrow_back_test,
    var sub_tilte: ArrayList<CreateProjectTitleModel> = arrayListOf()
)