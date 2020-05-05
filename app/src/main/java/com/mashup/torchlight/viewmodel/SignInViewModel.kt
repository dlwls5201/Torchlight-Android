package com.mashup.torchlight.viewmodel

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.mashup.base.baseview.BaseViewModel
import com.mashup.torchlight.model.SignInModel

class SignInViewModel : BaseViewModel() {
    val data = MutableLiveData<SignInModel>()

    init {
        data.value = SignInModel()
    }

    fun isBasicInfoFilled(): Boolean {
        return data.value?.let {
            return it.emailAddress.isNotEmpty()
                    && it.passwd.isNotEmpty()
        } ?: false
    }

    fun isValidEmail(): Boolean {
        return data.value?.let {
            val matcher = Patterns.EMAIL_ADDRESS.matcher(it.emailAddress)
            return@let matcher.find()
        } ?: false
    }
}