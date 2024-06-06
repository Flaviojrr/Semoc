package com.example.appsemoc5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PessoasAdapter : ListAdapter<Pessoa, PessoasAdapter.PessoaViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Pessoa>() {
        override fun areItemsTheSame(oldItem: Pessoa, newItem: Pessoa): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pessoa, newItem: Pessoa): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pessoa, parent, false)
        return PessoaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        val pessoa = getItem(position)
        holder.bind(pessoa)
    }

    class PessoaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pessoa: Pessoa) {
            itemView.findViewById<TextView>(R.id.nome).text = pessoa.nome
            itemView.findViewById<TextView>(R.id.biografia).text = pessoa.biografia
            val imageView = itemView.findViewById<ImageView>(R.id.foto)
            Glide.with(itemView.context).load(pessoa.fotoUrl).into(imageView)
        }
    }
}
