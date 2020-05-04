package com.mashup.torchlight.di

import com.mashup.torchlight.ui.project.viewmodel.ProjectMemberViewModel
import com.mashup.torchlight.ui.project.viewmodel.ProjectViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ProjectViewModel()
    }

    viewModel {
        ProjectMemberViewModel()
    }
}