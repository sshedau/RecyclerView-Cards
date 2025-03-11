package com.example.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CountriesAdapter(
    var countryNameList: ArrayList<String>,
    var detailsList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var context: Context
) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textviewCountryName : TextView = itemView.findViewById(R.id.textviewCountryName)
        var textviewDetails : TextView = itemView.findViewById(R.id.textviewDetails)
        var imageCountryFlag : CircleImageView = itemView.findViewById(R.id.imageCountryFlag)
        var cardView : CardView = itemView.findViewById(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_design, parent, false)

        return CountryViewHolder(view)

    }

    override fun getItemCount(): Int {
        return countryNameList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        Log.d("RecyclerView", "Binding data at position: $position")  // Debugging line

        holder.textviewCountryName.text = countryNameList.get(position)
        holder.textviewDetails.text = detailsList.get(position)
        holder.imageCountryFlag.setImageResource(imageList.get(position))

        holder.cardView.setOnClickListener {
            Toast.makeText(context, "You selected : ${countryNameList.get(position)}", Toast.LENGTH_SHORT).show()
        }

    }

}