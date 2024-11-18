package com.mobillor.themeresourcemodule.utils

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {


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


}