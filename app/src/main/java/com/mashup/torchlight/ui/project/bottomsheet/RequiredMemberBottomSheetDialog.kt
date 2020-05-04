package com.mashup.torchlight.ui.project.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.DialogBottomSheetRequiredMemberBinding
import com.mashup.torchlight.ui.project.model.ProjectModel
import com.mashup.torchlight.ui.project.viewmodel.ProjectMemberViewModel


class RequiredMemberBottomSheetDialog(
    private val projectMemberVM: ProjectMemberViewModel,
    private val member: ProjectModel.Member
) : BottomSheetDialogFragment() {

    private lateinit var binding: DialogBottomSheetRequiredMemberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.dialog_bottom_sheet_required_member,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(STYLE_NO_TITLE, R.style.dialogTransparent)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.memberVM = projectMemberVM
        binding.member = member
    }

}