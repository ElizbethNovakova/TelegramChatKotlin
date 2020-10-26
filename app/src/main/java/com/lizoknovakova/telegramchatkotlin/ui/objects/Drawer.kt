package com.lizoknovakova.telegramchatkotlin.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lizoknovakova.telegramchatkotlin.R
import androidx.appcompat.widget.Toolbar
import com.lizoknovakova.telegramchatkotlin.ui.fragments.SettingsFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class Drawer(val mainActivity: AppCompatActivity, val toolbar: Toolbar){

    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader

    fun create(){
        createHeader()
        createDrawerMenu()
    }

    private fun createDrawerMenu() {
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem()
                    .withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_create_groups)
                    .withName("New Group")
                    .withSelectable(false),
                PrimaryDrawerItem()
                    .withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_secret_chat)
                    .withName("Secret Chat")
                    .withSelectable(false),
                PrimaryDrawerItem()
                    .withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_create_channel)
                    .withName("Create Channel")
                    .withSelectable(false),
                PrimaryDrawerItem()
                    .withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_contacts)
                    .withName("Contacts")
                    .withSelectable(false),
                PrimaryDrawerItem()
                    .withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_phone)
                    .withName("Calls")
                    .withSelectable(false),
                PrimaryDrawerItem()
                    .withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_favorites)
                    .withName("Favourites")
                    .withSelectable(false),
                PrimaryDrawerItem()
                    .withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_settings)
                    .withName("Settings")
                    .withSelectable(false),
                DividerDrawerItem(),
                PrimaryDrawerItem()
                    .withIdentifier(107)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_invate)
                    .withName("Invite Friends")
                    .withSelectable(false),
                PrimaryDrawerItem()
                    .withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.ic_menu_help)
                    .withName("Help")
                    .withSelectable(false)
            ).withOnDrawerItemClickListener(object: Drawer.OnDrawerItemClickListener{
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when(position){
                        7 -> mainActivity.supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.dataContainer,
                                SettingsFragment()
                            ).commit()
                    }
                    return false
                }
            }).build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem()
                    .withName("Liza")
                    .withEmail("+3809745874")
            )
            .build()
    }
}