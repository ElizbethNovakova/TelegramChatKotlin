package com.lizoknovakova.telegramchatkotlin.ui.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.auth.PhoneAuthProvider
import com.lizoknovakova.telegramchatkotlin.MainActivity
import com.lizoknovakova.telegramchatkotlin.R
import com.lizoknovakova.telegramchatkotlin.activities.RegisterActivity
import com.lizoknovakova.telegramchatkotlin.utilits.AUTH
import com.lizoknovakova.telegramchatkotlin.utilits.AppTextWatcher
import com.lizoknovakova.telegramchatkotlin.utilits.replaceActivity
import com.lizoknovakova.telegramchatkotlin.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment(val mPhoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {
    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = mPhoneNumber
        register_enter_code.addTextChangedListener(AppTextWatcher{
            val string: String = register_enter_code.text.toString()
            if(string.length == 6){
                enterCode()
            }
        })
    }


    private fun enterCode(){
        val code = register_enter_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener(){ task ->
            if(task.isSuccessful){
                showToast("Welcome to Telegram")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else showToast(task.exception?.message.toString())
        }
    }
}