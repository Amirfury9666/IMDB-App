package com.fury.imdbapp.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
fun Context.toast(message : String?){
    message?.let {
        Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
    }
}


fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun Any.printLog(tag : String,message: String?){ Log.d(tag,message) }


inline fun <reified T : ViewModel> FragmentActivity.getViewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}