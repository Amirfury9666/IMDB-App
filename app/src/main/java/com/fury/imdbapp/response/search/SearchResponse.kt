package com.fury.imdbapp.response.search

import com.fury.imdbapp.response.search.Search
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SearchResponse {
    @SerializedName("Search")
    @Expose
    var search: ArrayList<Search>? = null
    @SerializedName("totalResults")
    @Expose
    var totalResults: String? = null
    @SerializedName("Response")
    @Expose
    var response: String? = null

}