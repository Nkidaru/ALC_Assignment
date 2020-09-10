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

class LearningLeadersFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_leaders, container, false)

        val recyclerView = v.findViewById(R.id.lrv) as RecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)

        //Make Api Call
       GadsApiClient.create().getLearningLeaders().enqueue(object:Callback<List<LearningLeadersResponse>>{
            override fun onResponse(
                call: Call<List<LearningLeadersResponse>>,
                response: Response<List<LearningLeadersResponse>>
            ) {
                Log.e("LearningLeaders","Success ${response.isSuccessful}")
                val leaders = response.body() ?: emptyList()
                recyclerView.adapter = LearningLeadersAdapter(leaders)
            }

            override fun onFailure(call: Call<List<LearningLeadersResponse>>, t: Throwable) {
                //Do something on failure
                Log.e("LearningLeaders","Error $t")
            }
        })

        return v
    }


}