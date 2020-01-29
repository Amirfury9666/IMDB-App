package com.fury.imdbapp.util

import java.io.IOException

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
class ApiException(message : String) : IOException(message)

class NoInternetException(message: String) : IOException(message)

class PathNotFoundException(message: String) : IOException(message)