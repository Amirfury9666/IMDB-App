package com.fury.imdbapp.util

import java.io.IOException

class ApiException(message : String) : IOException(message)

class NoInternetException(message: String) : IOException(message)

class PathNotFoundException(message: String) : IOException(message)