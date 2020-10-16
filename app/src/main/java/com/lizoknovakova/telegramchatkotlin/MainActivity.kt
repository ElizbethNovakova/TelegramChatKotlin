package com.lizoknovakova.telegramchatkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.lizoknovakova.telegramchatkotlin.databinding.ActivityMainBinding
import com.lizoknovakova.telegramchatkotlin.ui.fragments.ChatsFragment
import com.lizoknovakova.telegramchatkotlin.ui.objects.Drawer

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
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        mDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(R.id.chatsContainer,
                ChatsFragment()
            ).commit()

    }


}
