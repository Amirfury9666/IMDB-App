package com.fury.imdbapp.viewmodel

import androidx.lifecycle.ViewModel
import com.fury.imdbapp.callback.ResponseCallback
import com.fury.imdbapp.repository.MovieDetailRepository
import com.fury.imdbapp.response.detail.SearchDetail
import com.fury.imdbapp.util.Coroutines


/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class MovieDetailViewModel (private val repository : MovieDetailRepository) : ViewModel(){

    var responseCallback : ResponseCallback<SearchDetail>? = null

    fun fetchMovieDetails(imdbId : String){
        Coroutines.main {
            try {
                val response = repository.getMovieDetails(imdbId)
                responseCallback?.onSuccess(response)
            }catch (e : Exception){
                responseCallback?.onFailure(e.message)
            }
        }
    }
}