package com.fury.imdbapp.repository

import com.fury.imdbapp.base.network.ImDbService
import com.fury.imdbapp.base.network.SafeApiRequest
import com.fury.imdbapp.response.detail.SearchDetail

class MovieDetailRepository (private val  apiService  : ImDbService) : SafeApiRequest(){

    suspend fun getMovieDetails(imdbId : String) : SearchDetail {
        return apiRequest { apiService.getMovieDetails(imdbId,"json") }
    }
}