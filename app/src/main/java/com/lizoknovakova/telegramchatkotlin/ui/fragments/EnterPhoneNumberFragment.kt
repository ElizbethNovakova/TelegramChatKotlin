package com.lizoknovakova.telegramchatkotlin.ui.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.lizoknovakova.telegramchatkotlin.MainActivity
import com.lizoknovakova.telegramchatkotlin.R
import com.lizoknovakova.telegramchatkotlin.activities.RegisterActivity
import com.lizoknovakova.telegramchatkotlin.utilits.AUTH
import com.lizoknovakova.telegramchatkotlin.utilits.replaceActivity
import com.lizoknovakova.telegramchatkotlin.utilits.replaceFragment
import com.lizoknovakova.telegramchatkotlin.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import java.util.concurrent.TimeUnit


class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {

    private lateinit var mPhoneNumber: String
    private lateinit var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener { sendCode() }
        mCallback = object: PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onCodeSent(id: String, p1: PhoneAuthProvider.ForceResendingToken) {
                replaceFragment(EnterCodeFragment(mPhoneNumber, id))
            }

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                AUTH.signInWithCredential(credential).addOnCompleteListener(){task ->
                    if(task.isSuccessful){
                        showToast("Welcome to Telegram")
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    } else showToast(task.exception?.message.toString())
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
            }
        }
    }

    private fun sendCode() {
        if(register_input_phone.text.toString().isEmpty()){
            showToast(getString(R.string.register_message_to_enter_number))
        } else {
           authUser()
        }
    }

    private fun authUser(){
        mPhoneNumber = register_input_phone.text.toString()
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            mPhoneNumber, 60, TimeUnit.SECONDS, activity as RegisterActivity, mCallback
        )
    }
}