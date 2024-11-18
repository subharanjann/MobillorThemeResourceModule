package com.mobillor.themeresourcemodule.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.mobillor.themeresourcemodule.R

import com.mobillor.themeresourcemodule.utils.Common

class NatworkChangeListener : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (!Common.isConnectedToInternet(context)) {
            val builder = AlertDialog.Builder(context)
            val layout_dialog =
                LayoutInflater.from(context).inflate(R.layout.check_internet_dialog, null)
            builder.setView(layout_dialog)
            val btnRetry: AppCompatButton = layout_dialog.findViewById(R.id.btnRetry)
            //show dialog
            val dialog = builder.create()
            dialog.show()
            dialog.setCancelable(false)
            dialog.window!!.setGravity(Gravity.CENTER)
            btnRetry.setOnClickListener {
                dialog.dismiss()
                onReceive(context, intent)
            }
        }

    }
}