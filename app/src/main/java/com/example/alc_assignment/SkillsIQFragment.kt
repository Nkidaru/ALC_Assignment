package com.example.alc_assignment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SkillsIQFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_skills_i_q, container, false)


        val recyclerView = v.findViewById(R.id.rv) as RecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)


        //Make Api Call
        GadsApiClient.create().getSkillIQLeader().enqueue(object:
            Callback<List<SkillIQResponse>> {
            override fun onResponse(
                call: Call<List<SkillIQResponse>>,
                response: Response<List<SkillIQResponse>>
            ) {
                Log.e("SkillsIQ","Success ${response.isSuccessful}")
                val skillsIQ = response.body() ?: emptyList()
                recyclerView.adapter = SkillsIQAdapter(skillsIQ)
            }

            override fun onFailure(call: Call<List<SkillIQResponse>>, t: Throwable) {
                //Do something on failure
                Log.e("LearningLeaders","Error $t")
            }
        })

        return v
    }


}