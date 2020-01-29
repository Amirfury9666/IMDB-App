package com.fury.imdbapp.repository

import com.fury.imdbapp.base.network.ImDbService
import com.fury.imdbapp.base.network.SafeApiRequest
import com.fury.imdbapp.response.search.SearchResponse

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class SearchRepository (private val apiService: ImDbService) : SafeApiRequest(){
    suspend fun searchMovie(keyWork : String) : SearchResponse {
        return apiRequest { apiService.searchMovie(keyWork,"json") }
    }
}