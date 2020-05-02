package com.mashup.torchlight.ui.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.mashup.torchlight.R
import kotlinx.android.synthetic.main.layout_custom_three_btn.view.*


class CustomThreeBtn : LinearLayout {
    private var rg: RadioGroup? = null
    private var checkId: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, i: Int) : super(context) {
        checkId = i
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
        getAttrs(attrs, defStyleAttr)
    }

    private fun init() {
        orientation = LinearLayout.VERTICAL
        gravity = Gravity.CENTER
        setBackgroundColor(Color.WHITE)
        LayoutInflater.from(context).inflate(R.layout.layout_custom_three_btn, this, true)
        setCheckId(checkId)
        rg = findViewById(R.id.rg)
    }

    private fun getAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomThreeBtn)
        setTypeArray(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CustomThreeBtn, defStyle, 0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray) {
        setup()
        typedArray.recycle()
    }

    private fun setup() {

    }

    interface OnButtonClick {
        fun onSelect(index: Int)
    }

    fun setOnButtonClick(buttonClick: OnButtonClick?) {
        if (buttonClick != null) {
            rg!!.setOnCheckedChangeListener { group, checkedId ->
                if (rb1.id == checkedId) {
                    setCheckId(0)
                    buttonClick.onSelect(0)
                } else if (rb2.id == checkedId) {
                    setCheckId(1)
                    buttonClick.onSelect(1)
                } else if (rb3.id == checkedId) {
                    setCheckId(2)
                    buttonClick.onSelect(2)
                }
            }
        }
    }
    fun setText(t1:String,t2:String,t3:String){
        rb1.text = t1
        rb2.text = t2
        rb3.text = t3
    }

    @SuppressLint("ResourceAsColor")
    fun setCheckId(checkId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rb1.background.setTint(context.resources.getColor(R.color.button_background))
            rb1.setTextColor(Color.GRAY)
            rb2.background.setTint(context.resources.getColor(R.color.button_background))
            rb2.setTextColor(Color.GRAY)
            rb3.background.setTint(context.resources.getColor(R.color.button_background))
            rb3.setTextColor(Color.GRAY)
        }
        this.checkId = checkId
        var rb: RadioButton = rb1
        when (checkId) {
            0 -> rb = rb1
            1 -> rb = rb2
            2 -> rb = rb3
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //item_card_background 전체가 바뀌브로 삭제 하겠습니다.
            //rb.background.setTint(context.resources.getColor(R.color.main_400))
            rb.setTextColor(Color.BLACK)
        }
    }

    fun getCheckId(): Int {
        return checkId
    }
}
