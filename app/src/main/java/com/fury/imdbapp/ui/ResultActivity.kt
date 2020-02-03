package com.fury.imdbapp.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.fury.imdbapp.R
import com.fury.imdbapp.adapter.ResultAdapter
import com.fury.imdbapp.base.core.BaseActivity
import com.fury.imdbapp.base.core.ViewModelFactory
import com.fury.imdbapp.callback.ResponseCallback
import com.fury.imdbapp.databinding.ActivityResultBinding
import com.fury.imdbapp.response.search.SearchResponse
import com.fury.imdbapp.util.hide
import com.fury.imdbapp.util.toast
import com.fury.imdbapp.viewmodel.SearchViewModel
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
class ResultActivity : BaseActivity<ActivityResultBinding>(),KodeinAware, ResponseCallback<SearchResponse> {


    override val kodein: Kodein by kodein()
    private lateinit var mSearchViewModel: SearchViewModel
    private val factory : ViewModelFactory by instance()
    private var mResultAdapter = ResultAdapter(arrayListOf())
    private lateinit var mBinding : ActivityResultBinding

    override val layoutRes: Int get() = R.layout.activity_result

    override fun getToolbar(binding: ActivityResultBinding): Toolbar? {return binding.toolbar}

    override fun onActivityReady(instanceState: Bundle?, binding: ActivityResultBinding) {
        mBinding = binding
        enableBack()
        setToolbarTitle("Results")
        mSearchViewModel  = ViewModelProviders.of(this,factory).get(SearchViewModel::class.java)
        mSearchViewModel.responseCallback = this
        intent?.getStringExtra("keyword")?.let {
            mSearchViewModel.searchMovie(it)
        }

        binding.resultRecycler.adapter = mResultAdapter
    }

    override fun onSuccess(response: SearchResponse) {
        mBinding.progressBar.hide()

        if (response.response == "True"){
            response.search?.let {
                mResultAdapter.addItems(it)
            }
        }else{
            toast("Result Not Found")
        }

    }

    override fun onFailure(message: String?) {
        message?.let {
            toast(it)
        }
    }


}
