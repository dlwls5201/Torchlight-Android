package com.mashup.torchlight.ui.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.FragmentCreateProjectPlaceBinding

class CreateProjectPlaceFragment :
    ProjectBaseFragment<FragmentCreateProjectPlaceBinding>(R.layout.fragment_create_project_place) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /* companion object {
         @JvmStatic
         fun newInstance(movePageListener: CreateProjectActivity.IMovePageListener):
                 CreateProjectPlaceFragment {
             val fragment = CreateProjectPlaceFragment()
             fragment.movePage = movePageListener
             return fragment
         }
     }*/
}
