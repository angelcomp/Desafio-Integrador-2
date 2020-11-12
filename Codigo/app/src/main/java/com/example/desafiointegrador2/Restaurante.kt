package com.example.desafiointegrador2

import java.io.Serializable

class Restaurante(var id: Int, var nome: String, val endereço: String, val horario: String, val img: Int): Serializable {
    override fun toString(): String {
        return "Restaurante(nome='$nome', endereço='$endereço', horario='$horario', img=$img)"
    }
}