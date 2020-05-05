package com.mashup.torchlight.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.base.baseview.BaseViewModel
import com.mashup.base.ext.SingleLiveEvent
import com.mashup.domain.repository.ProjectRepository
import com.mashup.torchlight.ui.project.model.ProjectModel
import com.mashup.torchlight.ui.project.model.mapToPresentation

class HomeViewModel(
    private val projectRepository: ProjectRepository
) : BaseViewModel() {

    private val _toast = SingleLiveEvent<String>()
    val toastLiveData: LiveData<String> get() = _toast

    private val _projects = MutableLiveData<List<ProjectModel>>()
    val projects: LiveData<List<ProjectModel>> get() = _projects

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun loadData() {
        projectRepository.getProjects()
            .map { it.mapToPresentation() }
            .doOnSubscribe {
                _isLoading.value = true
            }
            .doOnTerminate {
                _isLoading.value = false
            }
            .subscribe({
                _projects.value = it
            }) {
                _toast.value = it.message
            }.also {
                compositeDisposable.add(it)
            }
    }
}