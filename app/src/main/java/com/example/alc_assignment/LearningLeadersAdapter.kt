package com.example.alc_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


//Naming of LearningLeaders
class LearningLeadersAdapter(var leaders: List<LearningLeadersResponse>) :
    RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder>() {

val url = "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.leader_listview, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtName.text = leaders[position].name
        holder.txtHours.text = leaders[position].hours.toString()
        holder.txtCountry.text=leaders[position].country
       // holder.imageV.setImageResource(leaders[position].badgeUrl)

        Picasso.get()
            .load(url)
            .placeholder(R.drawable.user_placeholder)
            .error(R.drawable.user_placeholder_error)
            .into(holder.imageV)

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return leaders.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtName: TextView = itemView.findViewById(R.id.leadername)
        var txtHours: TextView = itemView.findViewById(R.id.hours)
        var txtCountry:TextView = itemView.findViewById(R.id.country)
        var imageV:ImageView=itemView.findViewById(R.id.image)

    }
}