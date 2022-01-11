package com.example.onelinediary_kotlin.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onelinediary_kotlin.databinding.DialogSelectBinding

class SelectDialog (
    private val _message: String,
    private val btnText1: String,
    private val btnText2: String,
    private val listener1: View.OnClickListener? = null,
    private val listener2: View.OnClickListener? = null
) : BaseDialog() {
    private lateinit var binding: DialogSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogSelectBinding.inflate(inflater, container, false)

        with(binding) {
            message.text = _message

            click1.text = btnText1
            listener1?.also {
                click1.setOnClickListener {
                    it.callOnClick()
                    dismiss()
                }
            }

            click1.setOnClickListener {
                listener1?.also { listener1 ->
                    listener1.onClick(it)
                }

                dismiss()
            }

            click2.text = btnText2
            click2.setOnClickListener {
                listener2?.also { listener2 ->
                    listener2.onClick(it)
                }

                dismiss()
            }
        }

        return binding.root
    }
}