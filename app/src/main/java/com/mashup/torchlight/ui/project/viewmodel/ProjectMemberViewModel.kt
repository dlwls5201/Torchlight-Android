package com.mashup.torchlight.ui.project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.torchlight.base.BaseViewModel
import com.mashup.torchlight.ui.project.model.ProjectModel

class ProjectMemberViewModel : BaseViewModel() {

    private val _planer = MutableLiveData<ProjectModel.Member>(ProjectModel.Member.PLANNER(0, 1))
    val planer: LiveData<ProjectModel.Member> get() = _planer

    private val _client = MutableLiveData<ProjectModel.Member>(ProjectModel.Member.CLIENT(0, 1))
    val client: LiveData<ProjectModel.Member> get() = _client

    private val _server = MutableLiveData<ProjectModel.Member>(ProjectModel.Member.SERVER(0, 1))
    val server: LiveData<ProjectModel.Member> get() = _server

    private val _designer = MutableLiveData<ProjectModel.Member>(ProjectModel.Member.DESIGNER(0, 1))
    val designer: LiveData<ProjectModel.Member> get() = _designer

    fun initMember(
        planer: ProjectModel.Member,
        client: ProjectModel.Member,
        server: ProjectModel.Member,
        designer: ProjectModel.Member
    ) {
        _planer.value = planer
        _client.value = client
        _server.value = server
        _designer.value = designer
    }

    fun addJoinedMember(member: ProjectModel.Member) {
        when (member) {
            is ProjectModel.Member.PLANNER -> {
                val newMember = _planer.value?.addJoinedMember(member)
                _planer.postValue(newMember)
            }
            is ProjectModel.Member.CLIENT -> {
                val newMember = _client.value?.addJoinedMember(member)
                _client.postValue(newMember)
            }
            is ProjectModel.Member.SERVER -> {
                val newMember = _server.value?.addJoinedMember(member)
                _server.postValue(newMember)
            }
            is ProjectModel.Member.DESIGNER -> {
                val newMember = _designer.value?.addJoinedMember(member)
                _designer.postValue(newMember)
            }
        }
    }

    fun removeJoinedMember(member: ProjectModel.Member) {
        _planer.value?.removeJoinedMember(member).run {
            when (this) {
                is ProjectModel.Member.PLANNER -> _planer.value = this
                is ProjectModel.Member.CLIENT -> _client.value = this
                is ProjectModel.Member.SERVER -> _server.value = this
                is ProjectModel.Member.DESIGNER -> _designer.value = this
            }
        }
    }

    fun addRequiredMember(member: ProjectModel.Member) {
        when (member) {
            is ProjectModel.Member.PLANNER -> {
                val newMember = _planer.value?.addRequiredMember(member)
                _planer.postValue(newMember)
            }
            is ProjectModel.Member.CLIENT -> {
                val newMember = _client.value?.addRequiredMember(member)
                _client.postValue(newMember)
            }
            is ProjectModel.Member.SERVER -> {
                val newMember = _server.value?.addRequiredMember(member)
                _server.postValue(newMember)
            }
            is ProjectModel.Member.DESIGNER -> {
                val newMember = _designer.value?.addRequiredMember(member)
                _designer.postValue(newMember)
            }
        }
    }

    fun removeRequiredMember(member: ProjectModel.Member) {
        _planer.value?.removeRequiredMember(member).run {
            when (this) {
                is ProjectModel.Member.PLANNER -> _planer.value = this
                is ProjectModel.Member.CLIENT -> _client.value = this
                is ProjectModel.Member.SERVER -> _server.value = this
                is ProjectModel.Member.DESIGNER -> _designer.value = this
            }
        }
    }

    fun getLiveDataMember(member: ProjectModel.Member): MutableLiveData<ProjectModel.Member> {
        return when (member) {
            is ProjectModel.Member.PLANNER -> _planer
            is ProjectModel.Member.CLIENT -> _client
            is ProjectModel.Member.SERVER -> _server
            is ProjectModel.Member.DESIGNER -> _designer
        }
    }

}
