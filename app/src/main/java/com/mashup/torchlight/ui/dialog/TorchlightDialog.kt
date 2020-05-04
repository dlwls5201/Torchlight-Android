package com.mashup.torchlight.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mashup.torchlight.R
import com.mashup.torchlight.databinding.DialogTorchLightBinding

class TorchlightDialog : DialogFragment() {

    companion object {

        private const val TITLE = "title"
        private const val MESSAGE = "message"
        private const val BTN_OK = "btn_ok"
        private const val BTN_CANCEL = "btn_cancel"

        fun create(
            title: String,
            message: String? = null,
            btnOk: String? = null,
            btnCancel: String? = null
        ) = TorchlightDialog().apply {
            arguments = bundleOf(
                Pair(TITLE, title),
                Pair(MESSAGE, message),
                Pair(BTN_OK, btnOk),
                Pair(BTN_CANCEL, btnCancel)
            )
        }
    }

    private lateinit var binding: DialogTorchLightBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(BottomSheetDialogFragment.STYLE_NO_TITLE, R.style.dialogTransparent)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_torch_light, container, false)
        return binding.root
    }


    private var positiveListener: (() -> Unit)? = null

    fun setPositoveButtonListener(listener: () -> Unit) {
        positiveListener = listener
    }

    private var negativeListener: (() -> Unit)? = null

    fun setNegativeButtonListener(listener: () -> Unit) {
        negativeListener = listener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(TITLE)!!
        val message = arguments?.getString(MESSAGE)
        val btnOk = arguments?.getString(BTN_OK)
        val btnCancel = arguments?.getString(BTN_CANCEL)

        with(binding) {

            tvTorchLightTitle.text = title

            if (message.isNullOrEmpty()) {
                tvTorchLightDescription.visibility = View.GONE
            } else {
                tvTorchLightDescription.visibility = View.VISIBLE
                tvTorchLightDescription.text = message
            }

            if (btnOk.isNullOrEmpty().not()) {
                btnTorchLightOk.text = btnOk
            }

            if (btnCancel.isNullOrEmpty()) {
                btnTorchLightCancel.visibility = View.GONE
            } else {
                btnTorchLightCancel.visibility = View.VISIBLE
            }

            btnTorchLightOk.setOnClickListener {
                positiveListener?.invoke()
                dismiss()
            }

            btnTorchLightCancel.setOnClickListener {
                negativeListener?.invoke()
                dismiss()
            }
        }
    }
}