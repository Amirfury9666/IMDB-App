package com.fury.imdbapp.base.network

import com.fury.imdbapp.response.detail.SearchDetail
import com.fury.imdbapp.response.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImDbService {
    @GET("/")
    suspend fun searchMovie(@Query("s") searchKeyWord : String, @Query("r") responseType : String) : Response<SearchResponse>

    @GET("/")
    suspend fun getMovieDetails(@Query("i") imdbId : String,@Query("r") responseType : String) : Response<SearchDetail>
}