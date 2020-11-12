package com.example.desafiointegrador2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PratosAdapter(private val listaPratos: ArrayList<Pratos>, val listener: onRestClickListener): RecyclerView.Adapter<PratosAdapter.RestViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PratosAdapter.RestViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_prato, parent, false)
        return RestViewHolder(itemView)
    }

    override fun getItemCount() = listaPratos.size

    override fun onBindViewHolder(holder: PratosAdapter.RestViewHolder, position: Int) {
        var prato = listaPratos.get(position)

        holder.nomePrato.text = prato.nome
        holder.imgPrato.setImageResource(prato.img)
    }

    interface onRestClickListener {
        fun pratoClick( position: Int )
    }

    inner class RestViewHolder(itemView: View): RecyclerView.ViewHolder (itemView), View.OnClickListener {
        val nomePrato: TextView = itemView.findViewById(R.id.nomePrato)
        val imgPrato: ImageView = itemView.findViewById(R.id.imgPrato)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition

            if (RecyclerView.NO_POSITION != position) {
                listener.pratoClick(position)
            }
        }
    }
}