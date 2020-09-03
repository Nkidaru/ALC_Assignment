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
 * Use the [Leaders.newInstance] factory method to
 * create an instance of this fragment.
 */
class Leaders : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_leaders, container, false)

        val animalRecyclerView = v.findViewById(R.id.lrv) as RecyclerView
        animalRecyclerView.layoutManager =
            LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)

        var leaders = ArrayList<Leaders_details>()

        leaders.add(Leaders_details("Pius", "122"))
        leaders.add(Leaders_details("Solomon", "127"))
        leaders.add(Leaders_details("Silvester", "129"))
        leaders.add(Leaders_details("Trizza", "140"))

        animalRecyclerView.adapter = Learning_Leaders_Adapter(leaders)

        return v
    }


}