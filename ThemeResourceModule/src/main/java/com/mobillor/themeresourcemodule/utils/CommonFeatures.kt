package com.mobillor.themeresourcemodule.utils

import android.text.InputFilter
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.mobillor.themeresourcemodule.R

import java.text.DecimalFormat
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun Double.formatDouble(): String {

    val roundedString = String.format("%.3f", this)

    // Convert back to double to remove trailing zeros
    val withoutTrailingZeros = roundedString.toDouble()

    // Check if the number is effectively an integer
    return if (withoutTrailingZeros % 1.0 == 0.0) {
        withoutTrailingZeros.toInt().toString()
    } else {
        withoutTrailingZeros.toString()
    }
}

fun formatForThreeDigits(doubleData: Double): Double {
    val decimalFormat = DecimalFormat("#.###")
    return decimalFormat.format(doubleData).toDouble()

    fun restrictDecimalDigits(editText: EditText) {
        editText.filters = arrayOf(InputFilter { source, _, _, dest, _, _ ->
            if (source == "." && dest.toString().contains(".")) {
                return@InputFilter ""
            }
            if (dest.toString().contains(".")) {
                val index = dest.indexOf(".")
                val lengthAfterDecimal = dest.length - index - 1
                if (lengthAfterDecimal >= 3) {
                    return@InputFilter ""
                }
            }
            null
        })
    }
}

fun restrictDecimalDigits(editText: EditText) {
    editText.filters = arrayOf(InputFilter { source, _, _, dest, _, _ ->
        if (source == "." && dest.toString().contains(".")) {
            return@InputFilter ""
        }
        if (dest.toString().contains(".")) {
            val index = dest.indexOf(".")
            val lengthAfterDecimal = dest.length - index - 1
            if (lengthAfterDecimal >= 3) {
                return@InputFilter ""
            }
        }
        null
    })
}

fun formatDateTime(dateString: String?): String? {
    // Define the input and output date formats
    val inputFormatter = DateTimeFormatter.ISO_DATE_TIME
    val outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    // Parse the input date string to a ZonedDateTime object
    val dateTime = ZonedDateTime.parse(dateString, inputFormatter)

    // Format the ZonedDateTime object to the desired output format
    return dateTime.withZoneSameInstant(ZoneId.systemDefault()).format(outputFormatter)
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