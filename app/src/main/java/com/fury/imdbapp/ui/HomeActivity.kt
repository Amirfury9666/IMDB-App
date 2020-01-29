package com.fury.imdbapp.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.fury.imdbapp.R
import com.fury.imdbapp.base.core.BaseActivity
import com.fury.imdbapp.base.core.ViewModelFactory
import com.fury.imdbapp.databinding.ActivityHomeBinding
import com.fury.imdbapp.repository.SearchRepository
import com.fury.imdbapp.viewmodel.SearchViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class HomeActivity : BaseActivity<ActivityHomeBinding>(), KodeinAware {
    override val kodein: Kodein by kodein()

    private lateinit var mSearchViewModel: SearchViewModel
    private val factory: ViewModelFactory<SearchRepository> by instance()
    override val layoutRes: Int get() = R.layout.activity_home

    override fun getToolbar(binding: ActivityHomeBinding): Toolbar? {
        return null
    }

    override fun onActivityReady(instanceState: Bundle?, binding: ActivityHomeBinding) {
        mSearchViewModel = ViewModelProviders.of(this, factory).get(SearchViewModel::class.java)
        binding.model = mSearchViewModel
    }



}
