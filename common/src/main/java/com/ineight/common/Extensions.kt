package com.ineight.common

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast

fun TextView.getTextString(): String = text.toString()


fun Context.toastMessage(message: String?){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.setVisibility(vibility: Boolean) {
    visibility = if(vibility) View.VISIBLE else View.GONE
}

