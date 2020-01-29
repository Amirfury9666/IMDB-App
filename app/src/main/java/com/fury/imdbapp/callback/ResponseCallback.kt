package com.fury.imdbapp.callback

interface ResponseCallback<T> {
    fun onSuccess(response :T)
    fun onFailure(message : String?)
}