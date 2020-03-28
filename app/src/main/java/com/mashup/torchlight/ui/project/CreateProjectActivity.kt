package com.mashup.torchlight.ui.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mashup.torchlight.BR
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.ActivityCreateProjectBinding
import com.mashup.torchlight.ui.base.BaseActivity
import com.mashup.torchlight.viewmodel.ProjectViewModel
import kotlinx.android.synthetic.main.item_btn_bottom.*


class CreateProjectActivity :
    BaseActivity<ActivityCreateProjectBinding>(R.layout.activity_create_project) {

    private lateinit var viewModel: ProjectViewModel
    lateinit var transaction: FragmentTransaction
    var currentItem = 0

    private val movePageListener = object : IMovePageListener {
        override fun moveNextPage() {
            binding.position = ++currentItem
            onFragmentChange(currentItem)
        }
        override fun movePrevPage() {
            binding.position = --currentItem
            onBackPressed()
        }
    }

    fun onFragmentChange(position: Int) {
        when (position) {
            PagePos.PASSION.pos -> replaceFragment(CreateProjectPlatformFragment())
            PagePos.FLATFORM.pos -> replaceFragment(CreateProjectPlatformFragment())
            PagePos.CATEGORY.pos -> replaceFragment(CreateProjectCategoryFragment())
            PagePos.TERM.pos -> replaceFragment(CreateProjectTermFragment())
            PagePos.PLACE.pos -> replaceFragment(CreateProjectPlaceFragment())
            PagePos.BASICINFO.pos -> replaceFragment(CreateProjectBasicInfoFragment())
            else -> replaceFragment(CreateProjectBasicInfoFragment())  // bullshit. just return anything
        }
    }

    enum class PagePos(val pos: Int) {
        PASSION(0), FLATFORM(1), CATEGORY(2), TERM(3), PLACE(4), BASICINFO(5)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack("").commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProjectViewModel::class.java)
        binding.setVariable(BR.projectVM, viewModel)
        binding.position = currentItem

        val PASSION = CreateProjectPassionFragment()
        transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, PASSION).commit()

        btnBottomLeft.setOnClickListener {
            movePageListener.movePrevPage()
        }
        btnBottomRight.setOnClickListener {
            movePageListener.moveNextPage()
        }

    }

    interface IMovePageListener {
        fun moveNextPage()
        fun movePrevPage()
    }
}

