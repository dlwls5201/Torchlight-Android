package com.mashup.torchlight.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mashup.base.baseview.BaseActivity
import com.mashup.base.util.DLog
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.ActivityMainBinding
import com.mashup.torchlight.ui.dialog.TorchlightDialog
import com.mashup.torchlight.ui.project.CreateProjectActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    BottomNavigationView.OnNavigationItemSelectedListener {

    companion object {

        const val REQUEST_CODE_CREATE_PROJECT = 1000
    }

    private val mainAdapter by lazy {
        MainFragmentAdapter(supportFragmentManager, lifecycle)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initMainAdapter()
        initButton()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        DLog.d("requestCode : $requestCode , resultCode : $resultCode, data : $data")
        if (requestCode == REQUEST_CODE_CREATE_PROJECT) {
            if (resultCode == Activity.RESULT_OK) {
                showCreateCompleteDialog()
            }
        }
    }

    private fun showCreateCompleteDialog() {
        val dialog = TorchlightDialog.create(
            title = "프로젝트 생성이\n완료되었습니다!",
            message = "프로젝트가 생성되었습니다. 새로운 멤버의 연락을 기다려보세요.",
            btnOk = "확인"
        ).apply {
            setPositoveButtonListener {
                mainAdapter.reloadHomeFragment()
            }
        }
        dialog.show(supportFragmentManager, dialog.tag)
    }

    private fun initMainAdapter() {
        with(binding) {
            vpMain.adapter = mainAdapter
            vpMain.isUserInputEnabled = false
        }
    }

    private fun initButton() {
        with(binding) {
            btnMain.setOnNavigationItemSelectedListener(this@MainActivity)

            btnMainCreateProject.setOnClickListener {
                startActivityForResult(
                    Intent(this@MainActivity, CreateProjectActivity::class.java),
                    REQUEST_CODE_CREATE_PROJECT
                )
            }
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.bottom_navigation_item_home -> {
                changeMainFragment(MainFragmentAdapter.MinaScreen.HOME.pos)
            }
            R.id.bottom_navigation_item_my_project -> {
                changeMainFragment(MainFragmentAdapter.MinaScreen.MY_PROJECT.pos)
            }
            R.id.bottom_navigation_item_notification -> {
                changeMainFragment(MainFragmentAdapter.MinaScreen.NOTIFICATION.pos)
            }
            R.id.bottom_navigation_item_my_page -> {
                changeMainFragment(MainFragmentAdapter.MinaScreen.MY_PAGE.pos)
            }
            else -> {
                return false
            }

        }
        return true
    }

    private fun changeMainFragment(pos: Int) {
        binding.vpMain.setCurrentItem(pos, false)
    }
}
