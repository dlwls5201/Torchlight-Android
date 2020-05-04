package com.mashup.torchlight.repository

import com.mashup.torchlight.entity.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ProjectRepository {

    fun getProjects(): Single<List<ProjectEntity>>

    fun addProject(projectEntity: ProjectEntity): Completable
}