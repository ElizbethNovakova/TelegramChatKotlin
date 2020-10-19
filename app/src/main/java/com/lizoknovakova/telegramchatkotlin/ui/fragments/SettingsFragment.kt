package com.lizoknovakova.telegramchatkotlin.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import com.lizoknovakova.telegramchatkotlin.R


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }
}