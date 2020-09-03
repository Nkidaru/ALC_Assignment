package com.example.alc_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Learning_Leaders_Adapter(var leaders: ArrayList<Leaders_details>) :
    RecyclerView.Adapter<Learning_Leaders_Adapter.ViewHolder>() {


    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.leader_listview, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.image.setImageResource(students[position].image)
        holder.leaderName.text = leaders[position].leaders_name
        holder.leaderPoints.text = leaders[position].points

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return leaders.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var image:ImageView
        var leaderName: TextView
        var leaderPoints: TextView

        init {
//image=itemView.findViewById(R.id.imagev)
            leaderName = itemView.findViewById(R.id.leadername)
            leaderPoints = itemView.findViewById(R.id.leaderpoints)
        }

    }
}