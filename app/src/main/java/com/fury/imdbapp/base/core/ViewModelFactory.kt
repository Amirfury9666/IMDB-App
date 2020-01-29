package com.fury.imdbapp.base.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fury.imdbapp.repository.MovieDetailRepository
import com.fury.imdbapp.repository.SearchRepository
import com.fury.imdbapp.viewmodel.MovieDetailViewModel
import com.fury.imdbapp.viewmodel.SearchViewModel
/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class ViewModelFactory<R>(private val repository : R) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass){
            when{
                isAssignableFrom(SearchViewModel::class.java) -> SearchViewModel(repository as SearchRepository)
                isAssignableFrom(MovieDetailViewModel::class.java) -> MovieDetailViewModel(repository as MovieDetailRepository)
                else -> error("Invalid View Model")
            }as T
        }

}