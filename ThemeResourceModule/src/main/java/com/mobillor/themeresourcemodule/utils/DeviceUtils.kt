package com.mobillor.themeresourcemodule.utils

import android.os.Build

object DeviceUtils {
    fun getDeviceType(): String {
        val model = Build.MODEL
        val manufacturer = Build.MANUFACTURER
        return if (model.startsWith(manufacturer, ignoreCase = true)) {
            capitalize(model)
        } else {
            capitalize(manufacturer) + " " + model
        }
    }
    private fun capitalize(s: String): String {
        if (s.isEmpty()) return s
        return s.substring(0, 1).toUpperCase() + s.substring(1)
    }
}