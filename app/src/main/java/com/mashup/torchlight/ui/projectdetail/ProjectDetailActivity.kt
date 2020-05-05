package com.mashup.torchlight.ui.projectdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.mashup.base.baseview.BaseActivity
import com.mashup.base.ext.toast
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.ActivityProjectDetailBinding
import com.mashup.torchlight.ui.dialog.TorchlightDialog
import com.mashup.torchlight.ui.projectdetail.viewmodel.ProjectDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProjectDetailActivity :
    BaseActivity<ActivityProjectDetailBinding>(R.layout.activity_project_detail) {

    companion object {

        private const val EXTRA_PROJECT_ID = "project_id"

        fun startProjectDetailActivity(context: Context, id: Int) = run {
            context.startActivity(
                Intent(context, ProjectDetailActivity::class.java).apply {
                    putExtra(EXTRA_PROJECT_ID, id)
                }
            )
        }
    }

    private val projectViewModel by viewModel<ProjectDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = projectViewModel

        val id = intent.getIntExtra(EXTRA_PROJECT_ID, -1)
        if (id < 0) error("id must be bigger than -1")

        initObserve()
        initButton()
        projectViewModel.getProjectById(id)
    }

    private fun initObserve() {
        projectViewModel.toastLiveData.observe(this, Observer {
            toast(it)
        })

        projectViewModel.projectModel.observe(this, Observer {
            binding.model = it
        })
    }

    private fun initButton() {
        binding.btnProjectDetailApply.setOnClickListener {
            val dialog = TorchlightDialog.create(
                title = "제출이 완료되었습니다!",
                message = "프로젝트 지원서가 제출되었습니다.\n프로젝트 리더의 연락을 기다려보세요.",
                btnOk = "확인"
            )
            dialog.show(supportFragmentManager, dialog.tag)
        }
    }
}
