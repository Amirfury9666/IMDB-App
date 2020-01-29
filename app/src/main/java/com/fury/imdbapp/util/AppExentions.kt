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
 * Created By Amir Fury on Jan 16 2020
 *
 */
fun Context.toast(message : String?){
    message?.let {
        Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
    }
}

fun View.showSnack(message : String){
    Snackbar.make(this,message,Snackbar.LENGTH_LONG).show()
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun Any.printLog(tag : String,message: String?){ Log.d(tag,message) }

//fun Context.showProgress(message : String,isCancelable : Boolean){
//    DialogUtils.showProgressDialog(this,message,isCancelable)
//}
//
//fun Context.hideProgress(){
//    DialogUtils.hideProgress()
//}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}