package com.mashup.torchlight.di

import com.mashup.torchlight.mockrepositoryImpl.MockProjectRepoImpl
import com.mashup.torchlight.repository.ProjectRepository
import org.koin.dsl.module

val mockRepositoryModule = module {

    single<ProjectRepository> {
        MockProjectRepoImpl()
    }
}