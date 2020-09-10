package com.example.alc_assignment

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ProjectSubmissionFormUrlApi {
    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }


    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor) // same for .addInterceptor(...)
        .connectTimeout(30, TimeUnit.SECONDS) //Backend is really slow
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    //defining a Base URL
    fun create(): ProjectSubmitApi {
         return Retrofit.Builder()
             .client(okHttpClient)
            .baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ProjectSubmitApi::class.java)
    }
}