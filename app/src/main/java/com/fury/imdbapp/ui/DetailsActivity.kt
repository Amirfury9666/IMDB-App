package com.fury.imdbapp.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.fury.imdbapp.R
import com.fury.imdbapp.base.core.BaseActivity
import com.fury.imdbapp.base.core.ViewModelFactory
import com.fury.imdbapp.callback.ResponseCallback
import com.fury.imdbapp.databinding.ActivityDetailsBinding
import com.fury.imdbapp.repository.MovieDetailRepository
import com.fury.imdbapp.response.detail.SearchDetail
import com.fury.imdbapp.util.hide
import com.fury.imdbapp.util.show
import com.fury.imdbapp.util.toast
import com.fury.imdbapp.viewmodel.MovieDetailViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class DetailsActivity : BaseActivity<ActivityDetailsBinding>(),KodeinAware, ResponseCallback<SearchDetail> {
    override val kodein: Kodein by kodein()

    private lateinit var mDetailViewModel : MovieDetailViewModel
    private val factory : ViewModelFactory<MovieDetailRepository> by instance()
    private lateinit var mBinding : ActivityDetailsBinding
    override val layoutRes: Int get() = R.layout.activity_details
    override fun getToolbar(binding: ActivityDetailsBinding): Toolbar? {return binding.toolbar}

    override fun onActivityReady(instanceState: Bundle?, binding: ActivityDetailsBinding) {
        enableBack()
        setToolbarTitle("Details")
        mBinding =binding
        mDetailViewModel = ViewModelProviders.of(this,factory).get(MovieDetailViewModel::class.java)
        mDetailViewModel.responseCallback = this

        intent?.getStringExtra("id")?.let {
            mDetailViewModel.fetchMovieDetails(it)
        }

    }

    override fun onSuccess(response: SearchDetail) {
        mBinding.model = response
        mBinding.progressBar.hide()
        mBinding.container.show()
    }

    override fun onFailure(message: String?) {
        message?.let {
            toast(it)
        }
    }


}
