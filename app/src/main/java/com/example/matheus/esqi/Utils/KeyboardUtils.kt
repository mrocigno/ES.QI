package com.example.matheus.esqi.Utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object KeyboardUtils {
    fun hideKeyboard(view: View, ctx: Context) {
        val inputMethodManager = ctx.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
