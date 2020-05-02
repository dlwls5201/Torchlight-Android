package com.mashup.torchlight.ui.project.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mashup.torchlight.R
import com.mashup.torchlight.ext.toast
import kotlinx.android.synthetic.main.dialog_bottom_sheet_required_member.*


class RequiredMemberBottomSheetDialog : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_bottom_sheet_required_member, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(STYLE_NO_TITLE, R.style.dialogTransparent)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRequiredMember.setOnClickListener {
            requireContext().toast("준비중입니다.")
        }

        btnAllMember.setOnClickListener {
            requireContext().toast("준비중입니다.")
        }
    }
}