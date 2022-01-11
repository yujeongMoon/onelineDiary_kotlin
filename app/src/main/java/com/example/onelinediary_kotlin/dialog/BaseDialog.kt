package com.example.onelinediary_kotlin.dialog

import android.content.Context
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

open class BaseDialog : DialogFragment() {

    fun show(context: Context) {
        super.show((context as FragmentActivity).supportFragmentManager, "")
    }
}