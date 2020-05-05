package com.mashup.torchlight.di

import com.mashup.torchlight.ui.home.HomeViewModel
import com.mashup.torchlight.ui.project.viewmodel.ProjectMemberViewModel
import com.mashup.torchlight.ui.project.viewmodel.ProjectViewModel
import com.mashup.torchlight.ui.projectdetail.viewmodel.ProjectDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }

    viewModel { ProjectViewModel(get()) }
    viewModel { ProjectMemberViewModel() }

    viewModel { ProjectDetailViewModel(get()) }
}