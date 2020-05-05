package com.mashup.torchlight.ui.project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.base.baseview.BaseFragment
import com.mashup.base.baseview.BaseViewModel
import com.mashup.base.ext.SingleLiveEvent
import com.mashup.base.util.DLog
import com.mashup.domain.repository.ProjectRepository
import com.mashup.torchlight.ui.customview.itemselectorview.ItemSelectorData
import com.mashup.torchlight.ui.project.*
import com.mashup.torchlight.ui.project.model.ProjectModel
import com.mashup.torchlight.ui.project.model.mapToEntity

class ProjectViewModel(
    private val projectRepository: ProjectRepository
) : BaseViewModel() {

    enum class PagePos(val pos: Int) {
        PASSION(1),
        PLATFORM(2),
        CATEGORY(3),
        TERM(4),
        PLACE(5),
        BASICINFO(6),
        CONFIRM(7)
    }

    private val _barStep = MutableLiveData(PagePos.PASSION.pos)
    val barStep: LiveData<Int> get() = _barStep

    private val _nextFragment = MutableLiveData<BaseFragment<*>>()
    val nextFragment: LiveData<BaseFragment<*>> get() = _nextFragment

    private val _complete = SingleLiveEvent<Boolean>()
    val complete: LiveData<Boolean> get() = _complete

    var currentPos = PagePos.PASSION.pos
        private set

    var resultProjectModel = ProjectModel()
        private set

    fun goNextStep() {
        currentPos++
        DLog.d("goNextStep pos : $currentPos")
        _barStep.value = currentPos
        _nextFragment.postValue(getCreateProjectFragment(currentPos))
    }

    fun goBackStep() {
        currentPos--
        DLog.d("goBackStep pos : $currentPos")
        _barStep.value = currentPos
        _nextFragment.postValue(getCreateProjectFragment(currentPos))
    }

    fun setPassion(passion: ProjectModel.Passion) {
        resultProjectModel = resultProjectModel.copy(passion = passion)
    }

    fun setPlatform(platform: String, desktop: String, field: String) {
        resultProjectModel = resultProjectModel.copy(
            platform = ProjectModel.PlatformType.valueOf(platform),
            desktop = ProjectModel.DesktopType.valueOf(desktop),
            field = ProjectModel.FieldType.valueOf(field)
        )
    }

    fun setCategory(categories: List<ItemSelectorData>) {
        resultProjectModel = resultProjectModel.copy(
            categories = categories
        )
    }

    fun setProjectScale(scale: ProjectModel.ProjectScale) {
        resultProjectModel = resultProjectModel.copy(
            scale = scale
        )
    }

    fun setStartDate(date: String) {
        resultProjectModel = resultProjectModel.copy(
            startDate = date
        )
    }

    fun setMembers(
        planer: ProjectModel.Member,
        client: ProjectModel.Member,
        server: ProjectModel.Member,
        designer: ProjectModel.Member
    ) {
        resultProjectModel = resultProjectModel.copy(
            planer = planer,
            client = client,
            server = server,
            designer = designer
        )
    }

    fun setArea(area: String) {
        resultProjectModel = resultProjectModel.copy(area = area)
    }

    fun setBasicInfo(title: String, summary: String, description: String, phone: String) {
        resultProjectModel = resultProjectModel.copy(
            title = title,
            summary = summary,
            description = description,
            phone = phone
        )
    }

    private fun getCreateProjectFragment(pos: Int) = when (pos) {
        PagePos.PASSION.pos -> {
            CreateProjectPassionFragment.newInstance()
        }
        PagePos.PLATFORM.pos -> {
            CreateProjectPlatformFragment.newInstance()
        }
        PagePos.CATEGORY.pos -> {
            CreateProjectCategoryFragment.newInstance()
        }
        PagePos.TERM.pos -> {
            CreateProjectScaleAndTermFragment.newInstance()
        }
        PagePos.PLACE.pos -> {
            CreateProjectMemberAndPlaceFragment.newInstance()
        }
        PagePos.BASICINFO.pos -> {
            CreateProjectBasicInfoFragment.newInstance()
        }
        PagePos.CONFIRM.pos -> {
            CreateProjectConfirmFragment.newInstance()
        }
        else -> {
            initProjectData()
            CreateProjectPassionFragment.newInstance()
        }
    }

    private fun initProjectData() {
        currentPos = PagePos.PASSION.pos
        resultProjectModel = ProjectModel()
    }

    fun addProject() {
        projectRepository.addProject(
            resultProjectModel.mapToEntity()
        ).subscribe({
            _complete.value = true
        }) {
            _complete.value = false
        }.also {
            compositeDisposable.add(it)
        }
    }
}
