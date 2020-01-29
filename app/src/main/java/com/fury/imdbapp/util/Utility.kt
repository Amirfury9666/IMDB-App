package com.fury.imdbapp.util

import android.content.Context
import android.net.ConnectivityManager


/**
 *
 * Created By Amir Fury on Jan 20 2020
 *
 */

object Utility {

    fun isNetworkAvailable(context: Context) : Boolean {
        val connectivityManager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }
}