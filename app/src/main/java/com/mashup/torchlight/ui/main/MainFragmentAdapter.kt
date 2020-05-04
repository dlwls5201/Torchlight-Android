package com.mashup.torchlight.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mashup.torchlight.ui.home.HomeFragment
import com.mashup.torchlight.ui.mypage.MyPageFragment
import com.mashup.torchlight.ui.myproject.MyProjectFragment
import com.mashup.torchlight.ui.notifications.NotificationsFragment

class MainFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val homeFragment by lazy {
        HomeFragment.newInstance()
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            MinaScreen.HOME.pos -> homeFragment
            MinaScreen.MY_PROJECT.pos -> MyProjectFragment.newInstance()
            MinaScreen.NOTIFICATION.pos -> NotificationsFragment.newInstance()
            MinaScreen.MY_PAGE.pos -> MyPageFragment.newInstance()
            else -> HomeFragment.newInstance()
        }
    }

    override fun getItemCount() = 4

    enum class MinaScreen(val pos: Int) {
        HOME(0), MY_PROJECT(1), NOTIFICATION(2), MY_PAGE(3)
    }

    fun reloadHomeFragment() {
        homeFragment.loadData()
    }
}