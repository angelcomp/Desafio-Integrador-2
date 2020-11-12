package com.example.desafiointegrador2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PratosAdapter(private val listaRestaurante: ArrayList<Restaurante>, val listener: onRestClickListener): RecyclerView.Adapter<PratosAdapter.RestViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PratosAdapter.RestViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurante, parent, false)
        return RestViewHolder(itemView)
    }

    override fun getItemCount() = listaRestaurante.size

    override fun onBindViewHolder(holder: PratosAdapter.RestViewHolder, position: Int) {
        var restaurante = listaRestaurante.get(position)

        holder.tvNome.text = restaurante.nome
        holder.tvEnd.text = restaurante.endereço
        holder.tvhora.text = restaurante.horario
        holder.ivImg.setImageResource(restaurante.img)
    }

    interface onRestClickListener {
        fun restClick( position: Int )
    }

    inner class RestViewHolder(itemView: View): RecyclerView.ViewHolder (itemView), View.OnClickListener {
        val tvNome: TextView = itemView.findViewById(R.id.nomeRest)
        val tvEnd: TextView = itemView.findViewById(R.id.enderecoRest)
        val tvhora: TextView = itemView.findViewById(R.id.horaRest)
        val ivImg: ImageView = itemView.findViewById(R.id.imgRest)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition

            if (RecyclerView.NO_POSITION != position) {
                listener.restClick(position)
            }
        }
    }
}