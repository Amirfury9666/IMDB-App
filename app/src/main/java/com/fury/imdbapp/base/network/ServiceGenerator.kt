package com.fury.imdbapp.base.network

import android.content.Context
import com.fury.imdbapp.BuildConfig
import com.fury.imdbapp.util.Constants
import com.fury.imdbapp.util.NoInternetException
import com.fury.imdbapp.util.Utility
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * Created By Amir Fury on Jan 29 2020
 *
 * Email fury.amir93@gmail.com
 *
 */
private const val BASE_URL = Constants.BASE_URL

object ServiceGenerator {
    operator fun invoke( context: Context) : ImDbService {
        val requestInterceptor = Interceptor {chain ->
            val url = chain.request()
                .url().newBuilder().build()

            val request = chain.request()
                .newBuilder().apply {
                    addHeader(Constants.HEADER_KEY,Constants.API_KEY)
                }
                .url(url).build()

            return@Interceptor chain.proceed(request)
        }

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(NetworkInterceptor(context))
            .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ImDbService::class.java)

    }

    class NetworkInterceptor(private val context: Context) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            if (!Utility.isNetworkAvailable(context)){
                throw NoInternetException("No Internet Connection")
            }
            else{
                return chain.proceed(chain.request())
            }
        }
    }
}
