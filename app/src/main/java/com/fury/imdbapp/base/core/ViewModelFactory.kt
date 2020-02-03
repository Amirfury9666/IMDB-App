package com.fury.imdbapp.base.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fury.imdbapp.repository.ImDbRepository
import com.fury.imdbapp.viewmodel.MovieDetailViewModel
import com.fury.imdbapp.viewmodel.SearchViewModel

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class ViewModelFactory(private val repository : ImDbRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass){
            when{
                isAssignableFrom(SearchViewModel::class.java) -> SearchViewModel(repository)
                isAssignableFrom(MovieDetailViewModel::class.java) -> MovieDetailViewModel(repository)
                else -> error("Invalid View Model")
            }as T
        }

}