package com.mashup.torchlight.ui.project

import androidx.databinding.ViewDataBinding
import com.mashup.base.baseview.BaseFragment
import com.mashup.torchlight.ui.project.viewmodel.ProjectViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class ProjectBaseFragment<B : ViewDataBinding>(
    layoutId: Int
) : BaseFragment<B>(layoutId) {

    protected val projectVM: ProjectViewModel by sharedViewModel()

    abstract fun initData()

    override fun onStart() {
        super.onStart()
        initData()
    }

}