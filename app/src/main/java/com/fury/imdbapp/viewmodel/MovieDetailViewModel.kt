package com.fury.imdbapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fury.imdbapp.callback.ResponseCallback
import com.fury.imdbapp.repository.ImDbRepository
import com.fury.imdbapp.response.detail.SearchDetail
import com.fury.imdbapp.util.Coroutines


/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class MovieDetailViewModel (private val repository : ImDbRepository) : ViewModel(){

    var responseCallback : ResponseCallback<SearchDetail>? = null
    private var mSearchResult = MutableLiveData<SearchDetail>()

    fun fetchMovieDetails(imdbId : String){
        Coroutines.main {
            try {
                val response = repository.getMovieDetails(imdbId)
                mSearchResult.value = response
                responseCallback?.onSuccess(response)
            }catch (e : Exception){
                responseCallback?.onFailure(e.message)

            }
        }
    }
}