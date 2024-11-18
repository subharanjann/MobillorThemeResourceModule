package com.mobillor.themeresourcemodule.commonComposables.sealedClasses

import com.mobillor.themeresourcemodule.R


sealed class BottomNavItems (val route: String, val icon: Int, val label: String){
    object Home : BottomNavItems("home", R.drawable.homeicon2, "Home")
    object Account : BottomNavItems("Account", R.drawable.user2, "Account")
    object Settings : BottomNavItems("Settings", R.drawable.settingsicon2, "Settings")
}