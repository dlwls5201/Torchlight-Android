package com.mashup.torchlight.ui.home

import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import com.mashup.torchlight.R
import com.mashup.torchlight.base.BaseFragment
import com.mashup.torchlight.databinding.FragmentHomeBinding
import com.mashup.torchlight.databinding.ItemProjectBinding
import com.mashup.torchlight.ext.toast
import com.mashup.torchlight.simplerecyclerview.SimpleRecyclerViewAdapter
import com.mashup.torchlight.simplerecyclerview.SimpleViewHolder
import com.mashup.torchlight.ui.project.model.ProjectModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val homeViewModel: HomeViewModel by viewModel()

    private val projectAdapter by lazy {
        object : SimpleRecyclerViewAdapter<ProjectModel, ItemProjectBinding>(
            layoutRes = R.layout.item_project,
            bindingVariableId = BR.model
        ) {
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): SimpleViewHolder<ItemProjectBinding> {
                return super.onCreateViewHolder(parent, viewType).apply {
                    //TODO 상세 페이지 작업
                    itemView.setOnClickListener {
                        itemView.context?.toast(getItem(adapterPosition).toString())
                    }
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = homeViewModel

        initObserve()
        initButton()
        setUpRecycleView()
        loadData()
    }

    private fun initObserve() {
        homeViewModel.toastLiveData.observe(viewLifecycleOwner, Observer {
            requireContext().toast(it)
        })

        homeViewModel.projects.observe(viewLifecycleOwner, Observer {
            projectAdapter.replaceAll(it)
        })
    }

    private fun initButton() {
        btnFragmentHomeSearch.setOnClickListener {
            requireContext().toast("준비중입니다.")
        }
    }

    private fun setUpRecycleView() {
        with(binding.rvHomeProject) {
            adapter = projectAdapter
        }
    }

    fun loadData() {
        homeViewModel.loadData()
    }
}
