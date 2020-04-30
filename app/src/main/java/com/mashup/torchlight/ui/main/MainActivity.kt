package com.mashup.torchlight.ui.main

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mashup.torchlight.R
import com.mashup.torchlight.adapter.MainFragmentAdapter
import com.mashup.torchlight.base.BaseActivity
import com.mashup.torchlight.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private val mainViewModel: MainViewModel by viewModel()

    private val mainAdapter by lazy {
        MainFragmentAdapter(supportFragmentManager, lifecycle)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vpMain.adapter = mainAdapter
        vpMain.isUserInputEnabled = false

        bnvMain.setOnNavigationItemSelectedListener(this)
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
        vpMain.setCurrentItem(pos, false)
    }
}
