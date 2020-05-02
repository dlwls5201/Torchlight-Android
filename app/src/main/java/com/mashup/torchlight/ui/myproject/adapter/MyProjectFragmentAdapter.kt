package com.mashup.torchlight.ui.myproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mashup.torchlight.ui.myproject.MyProjectItemFragment

class MyProjectFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            MyProjectScreen.MY_PROJECT_MADE.pos -> MyProjectItemFragment.newInstance()
            MyProjectScreen.PARTICIPATING_PROJECT.pos -> MyProjectItemFragment.newInstance()
            MyProjectScreen.LIKED_PROJECT.pos -> MyProjectItemFragment.newInstance()
            else -> MyProjectItemFragment.newInstance()
        }
    }

    override fun getItemCount() = 3

    enum class MyProjectScreen(val pos: Int) {
        MY_PROJECT_MADE(0), PARTICIPATING_PROJECT(1), LIKED_PROJECT(2),
    }
}