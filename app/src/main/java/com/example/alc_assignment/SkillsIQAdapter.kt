package com.example.alc_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class SkillsIQAdapter(var skillsIQ: List<SkillIQResponse>) :
    RecyclerView.Adapter<SkillsIQAdapter.ViewHolder>() {
    val url="https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.skils_iq_listview, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtName.text = skillsIQ[position].name
        holder.txtScores.text = skillsIQ[position].score.toString()
        holder.txtCountry.text = skillsIQ[position].country

        Picasso.get()
            .load(url)
            .placeholder(R.drawable.user_placeholder)
            .error(R.drawable.user_placeholder_error)
            .into(holder.imageV)

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return skillsIQ.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.name)
        var txtScores: TextView = itemView.findViewById(R.id.score)
        var txtCountry: TextView = itemView.findViewById(R.id.country)
        var imageV:ImageView=itemView.findViewById(R.id.image)

    }
}