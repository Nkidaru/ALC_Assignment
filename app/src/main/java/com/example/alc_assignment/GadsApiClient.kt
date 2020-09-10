package com.example.alc_assignment

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//Created this api client ,creats our service with the baseurl and appends the endpoints
object GadsApiClient {
//defining a Base URL
    fun create(): GadsApiService {
        return Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GadsApiService::class.java)
    }

}
