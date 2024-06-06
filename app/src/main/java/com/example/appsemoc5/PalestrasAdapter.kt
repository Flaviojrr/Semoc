package com.example.appsemoc5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PalestrasAdapter : ListAdapter<Palestra, PalestrasAdapter.PalestraViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Palestra>() {
        override fun areItemsTheSame(oldItem: Palestra, newItem: Palestra): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Palestra, newItem: Palestra): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PalestraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_palestra, parent, false)
        return PalestraViewHolder(view)
    }

    override fun onBindViewHolder(holder: PalestraViewHolder, position: Int) {
        val palestra = getItem(position)
        holder.bind(palestra)
    }

    class PalestraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(palestra: Palestra) {
            itemView.findViewById<TextView>(R.id.titulo).text = palestra.titulo
            itemView.findViewById<TextView>(R.id.descricao).text = palestra.descricao
        }
    }
}
