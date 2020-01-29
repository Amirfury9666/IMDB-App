package com.fury.imdbapp.repository

import com.fury.imdbapp.base.network.ImDbService
import com.fury.imdbapp.base.network.SafeApiRequest
import com.fury.imdbapp.response.search.SearchResponse

class SearchRepository (private val apiService: ImDbService) : SafeApiRequest(){

    suspend fun searchMovie(keyWork : String) : SearchResponse {
        return apiRequest { apiService.searchMovie(keyWork,"json") }
    }
}