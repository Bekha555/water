package com.example.beta1.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log


class SessionManager(context: Context) {

    companion object {
        const val SHARED_PREFS = "apps_prefs"
        const val PAYCHECK_NUMBER = "paycheck_number"
    }

    private val mSharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS, 0)
    private val editor = mSharedPreferences.edit()

    var paycheckNumber: String?
        get() = mSharedPreferences.getString(
            PAYCHECK_NUMBER, ""
        )
        set(number) {
            with(editor) {
                putString(PAYCHECK_NUMBER, number)
                apply()
            }

        }

}
