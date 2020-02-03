package com.fury.imdbapp.repository

import com.fury.imdbapp.base.network.ImDbService
import com.fury.imdbapp.base.network.SafeApiRequest
import com.fury.imdbapp.response.detail.SearchDetail
import com.fury.imdbapp.response.search.SearchResponse


/**
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 */
class ImDbRepository (private val  apiService  : ImDbService) : SafeApiRequest(){
    suspend fun getMovieDetails(imDbId : String) : SearchDetail {
        return apiRequest { apiService.getMovieDetails(imDbId,"json") }
    }

    suspend fun searchMovie(keyWord : String) : SearchResponse {
        return apiRequest { apiService.searchMovie(keyWord,"json") }
    }
}