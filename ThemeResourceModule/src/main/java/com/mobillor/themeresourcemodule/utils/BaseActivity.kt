package com.mobillor.themeresourcemodule.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mobillor.themeresourcemodule.R

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

open class BaseActivity : AppCompatActivity() {

    lateinit var loadingPopup : Dialog

    protected fun initProgressDialog() {
        loadingPopup = Dialog(this)
        loadingPopup.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingPopup.setCancelable(false)
        loadingPopup.setContentView(R.layout.progress_bar_dialog)
        loadingPopup.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
    }


    fun statusBarColor(){
        val window = this.window
        window.statusBarColor = this.resources.getColor(R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
    fun customStatusBarColor(color : Color){
        val window = this.window
        window.statusBarColor = color.toArgb()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    fun View.visible(){
            visibility = View.VISIBLE
    }

    fun View.gone(){
        visibility = View.GONE
    }

    fun View.enable(){
        isEnabled = true
    }

    fun View.disable(){
        isEnabled = false
    }

    fun Button.greyColor(){
        backgroundTintList = ContextCompat.getColorStateList(context, R.color.grey)
    }

    fun Button.greenColor(){
        backgroundTintList = ContextCompat.getColorStateList(context, R.color.green)
    }


    fun String.convertDateFormat(): String? {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yy", Locale.getDefault())

        return try {
            val date = inputFormat.parse(this)
            outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            null
        }
    }


    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            @Suppress("DEPRECATION")
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }

}