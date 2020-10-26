package com.lizoknovakova.telegramchatkotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.lizoknovakova.telegramchatkotlin.R
import com.lizoknovakova.telegramchatkotlin.utilits.replaceFragment
import com.lizoknovakova.telegramchatkotlin.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*


class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {
    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener { sendCode() }
    }

    private fun sendCode() {
        if(register_input_phone.text.toString().isEmpty()){
            showToast(getString(R.string.register_message_to_enter_number))
        } else {
            replaceFragment(EnterCodeFragment())
        }
    }
}