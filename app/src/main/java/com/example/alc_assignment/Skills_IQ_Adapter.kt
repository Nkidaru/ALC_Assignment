package com.example.alc_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Skills_IQ_Adapter(var students: ArrayList<Student_details>) :
    RecyclerView.Adapter<Skills_IQ_Adapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.skils_iq_listview, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.image.setImageResource(students[position].image)
        holder.textViewStudName.text = students[position].students_name
        holder.textViewScores.text = students[position].score

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return students.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var image:ImageView
        var textViewStudName: TextView
        var textViewScores: TextView

        init {
//image=itemView.findViewById(R.id.imagev)
            textViewStudName = itemView.findViewById(R.id.name)
            textViewScores = itemView.findViewById(R.id.score)
        }

    }
}