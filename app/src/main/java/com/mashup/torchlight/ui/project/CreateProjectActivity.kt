package com.mashup.torchlight.ui.project

import android.os.Bundle
import androidx.lifecycle.observe
import com.mashup.torchlight.R
import com.mashup.torchlight.base.BaseActivity
import com.mashup.torchlight.databinding.ActivityCreateProjectBinding
import com.mashup.torchlight.ui.project.viewmodel.ProjectViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateProjectActivity :
    BaseActivity<ActivityCreateProjectBinding>(R.layout.activity_create_project) {

    private val projectVM: ProjectViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.projectVM = projectVM

        initTopBar()
        initObserver()
        showPassionFragment()
    }

    private fun initTopBar() {
        binding.viewTopBar.tvGlobalTopTitle.text = "프로젝트 만들기"
        binding.viewTopBar.btnGlobalTopLeft.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initObserver() {
        projectVM.nextFragment.observe(this) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, it)
                .commit()
        }
    }

    private fun showPassionFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CreateProjectPassionFragment.newInstance())
            .commit()
    }

    override fun onBackPressed() {
        if (projectVM.currentPos > ProjectViewModel.PagePos.PASSION.pos) {
            projectVM.goBackStep()
        } else {
            super.onBackPressed()
        }
    }
}

