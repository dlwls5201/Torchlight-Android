package com.mashup.torchlight.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mashup.torchlight.R
import com.mashup.torchlight.adapter.CreateProfileFragmentAdapter
import com.mashup.torchlight.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.activity_create_profile.*

class CreateProfileActivity : AppCompatActivity() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var signUpAdapter: CreateProfileFragmentAdapter

    private val movePageListener = object : IMovePageListener {
        override fun moveNextPage() {
            vpCreateProfile.setCurrentItem(vpCreateProfile.currentItem+1, true)
        }

        override fun movePrevPage() {
            vpCreateProfile.setCurrentItem(vpCreateProfile.currentItem - 1, true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        signUpAdapter = CreateProfileFragmentAdapter(supportFragmentManager, lifecycle, movePageListener)
        vpCreateProfile.adapter = signUpAdapter
        vpCreateProfile.isUserInputEnabled = false
        vpCreateProfile.offscreenPageLimit = signUpAdapter.itemCount
    }

    interface IMovePageListener {
        fun moveNextPage()
        fun movePrevPage()
    }
}
