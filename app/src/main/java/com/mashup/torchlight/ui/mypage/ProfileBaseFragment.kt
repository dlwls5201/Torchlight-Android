package com.mashup.torchlight.ui.mypage

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.mashup.torchlight.BR
import com.mashup.torchlight.base.BaseFragment
import com.mashup.torchlight.viewmodel.ProfileViewModel

open class ProfileBaseFragment<B : ViewDataBinding>(
    private val layoutId: Int
) : BaseFragment<B>(layoutId) {
    protected var movePage: CreateProfileActivity.IMovePageListener? = null
    protected lateinit var viewModel: ProfileViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity())[(ProfileViewModel::class.java)]
        binding.setVariable(BR.profile, viewModel)
    }
}