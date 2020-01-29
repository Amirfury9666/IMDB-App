package com.fury.imdbapp.callback

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
interface ResponseCallback<T> {
    fun onSuccess(response :T)
    fun onFailure(message : String?)
}