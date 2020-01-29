package com.fury.imdbapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fury.imdbapp.R
import com.fury.imdbapp.base.core.BaseListAdapter
import com.fury.imdbapp.response.search.Search

class ResultAdapter(private val list : ArrayList<Search>) : BaseListAdapter<Search>(DiffCallBack()) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.result_item
    }

    private class DiffCallBack : DiffUtil.ItemCallback<Search>() {
        override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
            return oldItem.equals(newItem)
        }
    }


    init {
        submitList(list)
    }

    fun addItems(list : ArrayList<Search>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

}