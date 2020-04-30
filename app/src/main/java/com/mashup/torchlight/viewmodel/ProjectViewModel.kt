package com.mashup.torchlight.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mashup.torchlight.R
import com.mashup.torchlight.base.BaseViewModel
import com.mashup.torchlight.model.CreateProjectModel
import com.mashup.torchlight.model.CreateProjectTitleModel
import com.mashup.torchlight.model.ProjectModel

class ProjectViewModel : BaseViewModel() {

    val data = MutableLiveData<CreateProjectModel>()
    val project = MutableLiveData<ProjectModel>()
    var contnet: ArrayList<CreateProjectTitleModel> = arrayListOf(
        CreateProjectTitleModel("열정을 설정해주세요.", "열정은 어쩌구저쩌구 도움말 텍스트에요. 아마 이 정도 길이면 되지 않을까 싶은데… "),
        CreateProjectTitleModel("플랫폼을 설정해주세요..", "열정은 어쩌구저쩌구 도움말 텍스트에요. 아마 이 정도 길이면 되지 않을까 싶은데… "),
        CreateProjectTitleModel("카테고리 설정해주세요..", "열정은 어쩌구저쩌구 도움말 텍스트에요. 아마 이 정도 길이면 되지 않을까 싶은데… "),
        CreateProjectTitleModel("를기간 설정해주세요..", "열정은 어쩌구저쩌구 도움말 텍스트에요. 아마 이 정도 길이면 되지 않을까 싶은데… "),
        CreateProjectTitleModel(
            "모집인원과 인원을 설정해주세요..",
            "열정은 어쩌구저쩌구 도움말 텍스트에요. 아마 이 정도 길이면 되지 않을까 싶은데… "
        ),
        CreateProjectTitleModel("기본정보를 입력해주세.", "열정은 어쩌구저쩌구 도움말 텍스트에요. 아마 이 정도 길이면 되지 않을까 싶은데… ")
    )

    enum class Passion(val int: Int, val level: String, val img: Int) {
        LOW(0, "LOW", R.drawable.edittext_background),
        MEDIUM(1, "MEDIUM", R.drawable.button_primary_background),
        MAX(2, "MAX", R.drawable.edittext_background_selected);
    }

    init {
        data.value = CreateProjectModel(sub_tilte = contnet)
        project.value = ProjectModel()
    }

    fun getSubTitle(position: Int): CreateProjectTitleModel {
        return data.value!!.sub_tilte[position]
    }

    fun setStagePassion(passion: Int) {
        when (passion) {
            Passion.LOW.int -> changePassion(Passion.LOW)
            Passion.MEDIUM.int -> changePassion(Passion.MEDIUM)
            Passion.MAX.int -> changePassion(Passion.MAX)
        }
    }

    //TODO:: function 이름 바꾸기...
    private fun changePassion(passion: Passion) {
        project.value!!.required_passion = passion.level
        data.value!!.image = passion.img
    }

    fun getStageImage(): CreateProjectModel {
        return data.value!!
    }
}
