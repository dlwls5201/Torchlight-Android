package com.mashup.torchlight.ui.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectPassionBinding
import com.mashup.torchlight.ui.customview.CustomThreeBtn
import kotlinx.android.synthetic.main.fragment_create_project_passion.*

class CreateProjectPassionFragment :
ProjectBaseFragment<FragmentCreateProjectPassionBinding>(R.layout.fragment_create_project_passion) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        btnSelectThree.setText("1단계", "2단계", "3단계")
        btnSelectThree.setOnButtonClick(object : CustomThreeBtn.OnButtonClick {
            override fun onSelect(index: Int) {
                btnSelectThree.setCheckId(index)
                viewModel.setStagePassion(index)
            }
        })

    }
}
