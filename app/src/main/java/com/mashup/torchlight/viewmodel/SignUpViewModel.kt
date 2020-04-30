package com.mashup.torchlight.viewmodel

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mashup.torchlight.model.SignUpModel
import com.mashup.torchlight.work.SignUpWork

class SignUpViewModel : ViewModel() {
    val data = MutableLiveData<SignUpModel>()
    val sendAuthBtnEnabled = MutableLiveData<Boolean>()

    val signUpWork = SignUpWork()

    init {
        data.value = SignUpModel()
    }

    fun isPasswordConfirmed() : Boolean {
        return data.value?.let {
            it.passwd == it.passwdConfirm
        } ?: false
    }

    fun isAuthCodeSame(code: String): Boolean {
        return data.value?.let {
            code == it.authCode
        } ?: false
    }

    fun isBasicInfoFilled(): Boolean {
        return data.value?.let {
            return it.emailAddress.isNotEmpty()
                    && it.name.isNotEmpty()
                    && it.passwd.isNotEmpty()
        } ?: false
    }

    fun isValidEmail() : Boolean {
        return data.value?.let {
            val matcher = Patterns.EMAIL_ADDRESS.matcher(it.emailAddress)
            return@let matcher.find()
        } ?: false
    }

    fun chkDuplicatedAndUpdateAuthBtn() {
        sendAuthBtnEnabled.value = data.value?.let {
             !signUpWork.isDuplicatedEmail(it.emailAddress)
        } ?: false
    }

    fun isPasswordConditionMatched(): Boolean {
        /*
        Password Condition:
        one more alphabet + one more number + one more special character + 10 or over characters
        */

        return true
    }

}
