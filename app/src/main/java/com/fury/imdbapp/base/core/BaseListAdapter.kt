package com.fury.imdbapp.base.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */

abstract class BaseListAdapter<T>(diffCallBack : DiffUtil.ItemCallback<T>) : ListAdapter<T, BaseListAdapter<T>.BaseViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),viewType,parent,false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(getItem(position))


    inner class BaseViewHolder(private val binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : T){
            binding.setVariable(BR.model,item)
            binding.executePendingBindings()
        }
    }
}