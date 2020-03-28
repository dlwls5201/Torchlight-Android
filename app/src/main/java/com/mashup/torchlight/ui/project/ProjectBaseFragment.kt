package com.mashup.torchlight.ui.project

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.mashup.torchlight.BR
import com.mashup.torchlight.ui.base.BaseFragment
import com.mashup.torchlight.viewmodel.ProjectViewModel

open class ProjectBaseFragment<B : ViewDataBinding>(
    layoutId: Int
) : BaseFragment<B>(layoutId) {
    protected lateinit var viewModel: ProjectViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity())[(ProjectViewModel::class.java)]
        binding.setVariable(BR.projectVM, viewModel)
    }
}