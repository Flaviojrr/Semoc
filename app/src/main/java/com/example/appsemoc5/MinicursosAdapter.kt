package com.example.appsemoc5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MinicursosAdapter : ListAdapter<Minicurso, MinicursosAdapter.MinicursoViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Minicurso>() {
        override fun areItemsTheSame(oldItem: Minicurso, newItem: Minicurso): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Minicurso, newItem: Minicurso): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MinicursoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_minicurso, parent, false)
        return MinicursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MinicursoViewHolder, position: Int) {
        val minicurso = getItem(position)
        holder.bind(minicurso)
    }

    class MinicursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(minicurso: Minicurso) {
            itemView.findViewById<TextView>(R.id.titulo).text = minicurso.titulo
            itemView.findViewById<TextView>(R.id.descricao).text = minicurso.descricao
        }
    }
}
