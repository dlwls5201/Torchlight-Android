package com.mashup.torchlight.ui.signin

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mashup.base.baseview.BaseActivity
import com.mashup.base.ext.toast
import com.mashup.torchlight.BR
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.ActivitySignInBinding
import com.mashup.torchlight.ui.signup.SignUpActivity
import com.mashup.torchlight.viewmodel.SignInViewModel
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)
        binding.setVariable(BR.signin, viewModel)

        setClickListeners()
    }

    private fun setClickListeners() {
        btnSignIn.setOnClickListener {
            if (!viewModel.isBasicInfoFilled()) {
                toast(R.string.signin_please_fill_all)
                return@setOnClickListener
            } else if (!viewModel.isValidEmail()) {
                toast(R.string.signin_email_is_invalid)
                return@setOnClickListener
            }
            // sign in
        }

        tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        tvFindPw.setOnClickListener {
            toast("Find password...")
        }
    }
}
