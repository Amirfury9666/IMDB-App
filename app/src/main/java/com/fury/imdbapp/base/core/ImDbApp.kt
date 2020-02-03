package com.fury.imdbapp.base.core

import android.app.Application
import com.fury.imdbapp.base.network.ServiceGenerator
import com.fury.imdbapp.repository.ImDbRepository
import com.fury.imdbapp.viewmodel.MovieDetailViewModel
import com.fury.imdbapp.viewmodel.SearchViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class ImDbApp : Application(),KodeinAware{
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ImDbApp))
        bind() from singleton { ServiceGenerator(instance()) }
        bind() from singleton { SearchViewModel(instance()) }
        bind() from singleton { ImDbRepository(instance()) }
        bind() from singleton { MovieDetailViewModel(instance()) }


        bind() from provider {
            ViewModelFactory (instance())
        }

    }

}