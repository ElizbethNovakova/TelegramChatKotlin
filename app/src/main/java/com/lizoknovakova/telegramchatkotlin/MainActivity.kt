package com.lizoknovakova.telegramchatkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.lizoknovakova.telegramchatkotlin.activities.RegisterActivity
import com.lizoknovakova.telegramchatkotlin.databinding.ActivityMainBinding
import com.lizoknovakova.telegramchatkotlin.ui.fragments.ChatsFragment
import com.lizoknovakova.telegramchatkotlin.ui.objects.Drawer
import com.lizoknovakova.telegramchatkotlin.utilits.AUTH
import com.lizoknovakova.telegramchatkotlin.utilits.replaceActivity
import com.lizoknovakova.telegramchatkotlin.utilits.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var mDrawer: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
    }

    private fun initFields(){
        mToolbar = mBinding.mainToolbar
        mDrawer = Drawer(this, mToolbar)
        AUTH = FirebaseAuth.getInstance()
        initFunc()
    }

    private fun initFunc() {
        if(AUTH.currentUser != null){
            setSupportActionBar(mToolbar)
            mDrawer.create()
            replaceFragment(ChatsFragment())
        } else {
            replaceActivity(RegisterActivity())
        }
    }
}
