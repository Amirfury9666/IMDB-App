package com.fury.imdbapp.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
object Coroutines {
    fun main(work : suspend (() -> Unit)) = CoroutineScope(Dispatchers.Main).launch {
        work()
    }

}