package com.example.alc_assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SkillsIQ.newInstance] factory method to
 * create an instance of this fragment.
 */
class SkillsIQ : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_skills_i_q, container, false)


        val animalRecyclerView = v.findViewById(R.id.rv) as RecyclerView
        animalRecyclerView.layoutManager =
            LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)

        var animals = ArrayList<Student_details>()

        animals.add(Student_details("Ann", "122"))
        animals.add(Student_details("Jack", "127"))
        animals.add(Student_details("James", "129"))
        animals.add(Student_details("Larry", "140"))

        animalRecyclerView.adapter = Skills_IQ_Adapter(animals)

        return v
    }


}