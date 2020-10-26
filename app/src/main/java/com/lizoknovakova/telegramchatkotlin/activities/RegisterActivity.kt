package com.lizoknovakova.telegramchatkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.lizoknovakova.telegramchatkotlin.R
import com.lizoknovakova.telegramchatkotlin.databinding.ActivityRegisterBinding
import com.lizoknovakova.telegramchatkotlin.ui.fragments.EnterPhoneNumberFragment
import com.lizoknovakova.telegramchatkotlin.utilits.replaceFragment
import kotlinx.android.synthetic.main.activity_register.view.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_text_your_phone)
        replaceFragment(EnterPhoneNumberFragment())
    }
}