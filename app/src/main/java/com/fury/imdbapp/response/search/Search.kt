package com.fury.imdbapp.response.search

import android.content.Intent
import android.view.View
import com.fury.imdbapp.ui.DetailsActivity
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Search {
    @SerializedName("Title")
    @Expose
    var title: String? = null
    @SerializedName("Year")
    @Expose
    var year: String? = null
    @SerializedName("imdbID")
    @Expose
    var imdbID: String? = null
    @SerializedName("Type")
    @Expose
    var type: String? = null
    @SerializedName("Poster")
    @Expose
    var poster: String? = null


    fun onItemClick(view : View){
        Intent(view.context,DetailsActivity::class.java).also {
            it.putExtra("id",imdbID)
            view.context.startActivity(it)
        }
    }

}