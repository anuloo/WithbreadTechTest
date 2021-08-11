package com.example.withbreadtechtest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.withbreadtechtest.data.WBCategory
import com.example.withbreadtechtest.data.WBVenue
import com.example.withbreadtechtest.databinding.AdapterVenueItemBinding

class WBVenueAdapter : RecyclerView.Adapter<VenueViewHolder>() {

    var venueList = mutableListOf<WBVenue>()

    fun setVenues(venues: List<WBVenue>) {
        this.venueList = venues.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterVenueItemBinding.inflate(inflater, parent, false)
        return VenueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        val venue = venueList[position]
        holder.binding.textViewName.text = "Venue: ${venue.name}"
        val category : List<WBCategory> = venue.categories
        if(category.size!=0){
            holder.binding.textViewCategorory.text = "Category: ${category.get(0).name}"
        }else{
            holder.binding.textViewCategorory.text = "Category: missing"
        }
        holder.binding.textViewDistance.text = "Distance: ${venue.location.distance.toString()} meters"
    }

    override fun getItemCount(): Int {
        return venueList.size
    }
}

class VenueViewHolder(val binding: AdapterVenueItemBinding) : RecyclerView.ViewHolder(binding.root) {

}
