package com.fury.imdbapp.repository

import com.fury.imdbapp.base.network.ImDbService
import com.fury.imdbapp.base.network.SafeApiRequest
import com.fury.imdbapp.response.detail.SearchDetail


/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class MovieDetailRepository (private val  apiService  : ImDbService) : SafeApiRequest(){
    suspend fun getMovieDetails(imdbId : String) : SearchDetail {
        return apiRequest { apiService.getMovieDetails(imdbId,"json") }
    }
}