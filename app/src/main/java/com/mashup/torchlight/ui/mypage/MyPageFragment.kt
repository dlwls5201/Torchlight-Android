package com.mashup.torchlight.ui.mypage

import android.content.Intent
import android.os.Bundle
import com.mashup.base.baseview.BaseFragment
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentMyPageBindingImpl
import com.mashup.torchlight.ui.signin.SignInActivity
import com.mashup.torchlight.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.fragment_my_page.*

class MyPageFragment :
    BaseFragment<FragmentMyPageBindingImpl>(R.layout.fragment_my_page) {

    companion object {
        fun newInstance() = MyPageFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnSignIn.setOnClickListener {
            startActivity(
                Intent(requireContext(), SignInActivity::class.java)
            )
        }
        btnSignUp.setOnClickListener {
            startActivity(
                Intent(requireContext(), SignUpActivity::class.java)
            )
        }
    }
}
