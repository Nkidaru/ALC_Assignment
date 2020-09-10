package com.example.alc_assignment

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

//Create endpoint interface,where all the endpoints leave,Get is for fetching data
interface GadsApiService {

    @GET("/api/hours")
    fun getLearningLeaders(): Call<List<LearningLeadersResponse>>

    @GET("/api/skilliq")
    fun getSkillIQLeader(): Call<List<SkillIQResponse>>



}

//Responses which mirror what the json returns
data class SkillIQResponse(
    val name: String,
    val score: Int,
    val country: String,
    val badgeUrl: String
)

data class LearningLeadersResponse(
    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String
)
