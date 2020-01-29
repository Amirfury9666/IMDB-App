package com.fury.imdbapp.viewmodel

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.fury.imdbapp.callback.ResponseCallback
import com.fury.imdbapp.repository.SearchRepository
import com.fury.imdbapp.response.search.SearchResponse
import com.fury.imdbapp.ui.ResultActivity
import com.fury.imdbapp.util.Coroutines
import com.fury.imdbapp.util.toast

private val TAG  = SearchViewModel::class.java.simpleName
class SearchViewModel(private val repository : SearchRepository) : ViewModel(){

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

    fun searchMovie(keyWork : String){
        Coroutines.main {
            try {
                val response = repository.searchMovie(keyWork)
                responseCallback?.onSuccess(response)
            }catch (e :Exception){
                responseCallback?.onFailure(e.message)
            }
        }
    }
}