package com.fury.imdbapp.viewmodel

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.fury.imdbapp.callback.ResponseCallback
import com.fury.imdbapp.repository.ImDbRepository
import com.fury.imdbapp.response.search.SearchResponse
import com.fury.imdbapp.ui.ResultActivity
import com.fury.imdbapp.util.Coroutines
import com.fury.imdbapp.util.toast

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class SearchViewModel(private val repository : ImDbRepository) : ViewModel(){

    var responseCallback : ResponseCallback<SearchResponse>?  = null
    var keyword : String? = null
    fun onSearchClick(view  : View){
        if (keyword.isNullOrEmpty()){
            view.context.toast("Please Enter A Movie Name")
            return
        }

        Intent(view.context,ResultActivity::class.java).also {
            it.putExtra("keyword",keyword)
            view.context.startActivity(it)
        }
    }

    fun searchMovie(keyWord : String){
        Coroutines.main {
            try {
                val response = repository.searchMovie(keyWord)
                responseCallback?.onSuccess(response)
            }catch (e :Exception){
                responseCallback?.onFailure(e.message)
            }
        }
    }
}