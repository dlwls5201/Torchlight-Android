package com.mashup.data.di

import com.mashup.data.mockrepositoryImpl.MockProjectRepoImpl
import com.mashup.domain.repository.ProjectRepository
import org.koin.dsl.module

val mockRepositoryModule = module {

    single<ProjectRepository> {
        MockProjectRepoImpl()
    }
}