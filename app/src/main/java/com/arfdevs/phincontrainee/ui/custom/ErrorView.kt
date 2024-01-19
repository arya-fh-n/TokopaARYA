package com.arfdevs.phincontrainee.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.arfdevs.phincontrainee.databinding.ErrorScreenBinding

class ErrorView(context: Context, attributeSet: AttributeSet, defStyleAttribute: Int): LinearLayout(context, attributeSet, defStyleAttribute) {

    private var binding: ErrorScreenBinding

    init {
        binding = ErrorScreenBinding.inflate(LayoutInflater.from(context), this, false)
    }

    fun setMessage(title: String, description: String, btnLabel: String = "", action: () -> (Unit)) = with(binding) {
        tvTitle.text = title
        tvDescription.text = description
        btnAction.isVisible = btnLabel.isNotEmpty()
        btnAction.text = btnLabel
        btnAction.setOnClickListener {
            action.invoke()
        }
    }
}