package com.mashup.torchlight.ui.signup

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.mashup.base.baseview.BaseFragment
import com.mashup.torchlight.BR
import com.mashup.torchlight.viewmodel.SignUpViewModel

open class SignUpBaseFragment<B : ViewDataBinding>(
    private val layoutId: Int
) : BaseFragment<B>(layoutId) {
    protected lateinit var movePage: SignUpActivity.ISignUpMovePageListener
    protected lateinit var viewModel: SignUpViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity())[(SignUpViewModel::class.java)]
        binding.setVariable(BR.signup, viewModel)
    }
}