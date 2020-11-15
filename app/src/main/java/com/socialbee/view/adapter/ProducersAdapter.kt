package com.socialbee.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.socialbee.R
import com.socialbee.model.Producer
import java.util.*

class ProducersAdapter (val producersListener: ProducersListener) : RecyclerView.Adapter<ProducersAdapter.ViewHolder>() {
    var listProducers = ArrayList<Producer>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
        R.layout.item_producer,parent,false))

    override fun onBindViewHolder(holder: ProducersAdapter.ViewHolder, position: Int) {
        val producer = listProducers[position]

        holder.tvItemProducerName.text = producer.name
        holder.tvItemProducerPhone.text = producer.phone

        Glide.with(holder.itemView.context)
            .load(producer.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivItemProducerImage)

        holder.itemView.setOnClickListener {
            producersListener.onProducerClicked(producer, position)
        }
    }

    override fun getItemCount() = listProducers.size

    fun updateData(data: List<Producer>){
        listProducers.clear()
        listProducers.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvItemProducerName = itemView.findViewById<TextView>(R.id.tvItemProducerName)
        val tvItemProducerPhone = itemView.findViewById<TextView>(R.id.tvItemProducerPhone)
        val ivItemProducerImage = itemView.findViewById<ImageView>(R.id.ivItemProducerImage)
    }
}