package com.mashup.domain.repository

import com.mashup.domain.entity.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ProjectRepository {

    fun getProjects(): Single<List<ProjectEntity>>

    fun addProject(projectEntity: ProjectEntity): Completable
}