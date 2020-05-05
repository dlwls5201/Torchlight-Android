package com.mashup.torchlight.ui.projectdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.base.baseview.BaseViewModel
import com.mashup.base.ext.SingleLiveEvent
import com.mashup.base.util.DLog
import com.mashup.domain.repository.ProjectRepository
import com.mashup.torchlight.ui.project.model.ProjectModel
import com.mashup.torchlight.ui.project.model.mapToPresentation

class ProjectDetailViewModel(
    private val projectRepo: ProjectRepository
) : BaseViewModel() {

    private val _toast = SingleLiveEvent<String>()
    val toastLiveData: LiveData<String> get() = _toast

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _projectItem = MutableLiveData<ProjectModel>()
    val projectModel: LiveData<ProjectModel> get() = _projectItem

    fun getProjectById(id: Int) {
        projectRepo.getProjectById(id)
            .doOnSubscribe {
                _isLoading.value = true
            }
            .doOnTerminate {
                _isLoading.value = false
            }
            .subscribe({
                _projectItem.value = it.mapToPresentation()
            }) {
                _toast.value = it.message
                DLog.e(it.message)
            }.also {
                compositeDisposable.add(it)
            }
    }
}