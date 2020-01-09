package com.mashup.torchlight.ui.myproject

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mashup.torchlight.R
import com.mashup.torchlight.adapter.MyProjectFragmentAdapter
import com.mashup.torchlight.databinding.FragmentMyProjectBindingImpl
import com.mashup.torchlight.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_my_project.*

class MyProjectFragment : BaseFragment<FragmentMyProjectBindingImpl>(R.layout.fragment_my_project) {

    private val myProjectAdapter by lazy {
        MyProjectFragmentAdapter(requireFragmentManager(), lifecycle)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewPager()
    }

    private fun initViewPager() {
        vpMyProject.adapter = myProjectAdapter
        vpMyProject.isUserInputEnabled = true

        TabLayoutMediator(
            tlMyProject, vpMyProject,
            TabLayoutMediator.TabConfigurationStrategy(::setTabLayoutTitle)
        ).attach()
    }

    private fun setTabLayoutTitle(tab: TabLayout.Tab, position: Int) {
        tab.text = when (position) {
            MyProjectFragmentAdapter.MyProjectScreen.MY_PROJECT_MADE.pos -> {
                resources.getString(R.string.my_project_made)
            }
            MyProjectFragmentAdapter.MyProjectScreen.PARTICIPATING_PROJECT.pos -> {
                resources.getString(R.string.my_project_participating)
            }
            MyProjectFragmentAdapter.MyProjectScreen.LIKED_PROJECT.pos -> {
                resources.getString(R.string.my_project_liked)
            }
            else -> ""
        }
    }

    companion object {
        fun newInstance() = MyProjectFragment()
    }

}
