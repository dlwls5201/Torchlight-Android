package com.mashup.torchlight.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mashup.base.ext.toast
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentSignUpEmailInputBinding
import kotlinx.android.synthetic.main.fragment_sign_up_email_input.*

class SignUpEmailInputFragment
    : SignUpBaseFragment<FragmentSignUpEmailInputBinding>(R.layout.fragment_sign_up_email_input) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnChkDuplicate.setOnClickListener {
            if (viewModel.isValidEmail()) {
                viewModel.chkDuplicatedAndUpdateAuthBtn()
            } else {
                requireContext().toast(getString(R.string.signup_email_is_invalid))
            }
        }
        btnSendAuthCode.setOnClickListener { movePage.moveNextPage() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(
            movePageListener: SignUpActivity.ISignUpMovePageListener
        ): SignUpEmailInputFragment {
            val fragment = SignUpEmailInputFragment()
            fragment.movePage = movePageListener
            return fragment
        }
    }


}
