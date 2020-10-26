package com.lizoknovakova.telegramchatkotlin.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.lizoknovakova.telegramchatkotlin.R
import com.lizoknovakova.telegramchatkotlin.utilits.AppTextWatcher
import com.lizoknovakova.telegramchatkotlin.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    override fun onStart() {
        super.onStart()

        register_enter_code.addTextChangedListener(AppTextWatcher{
            val string: String = register_enter_code.text.toString()
            if(string.length == 6){
                verifyCode()
            }
        })
    }


    fun verifyCode(){
        showToast("OK")
    }
}