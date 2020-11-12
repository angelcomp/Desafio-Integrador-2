package com.example.desafiointegrador2

class Restaurante(var id: Int, var nome: String, val endereço: String, val horario: String, val img: Int) {
    override fun toString(): String {
        return "Restaurante(nome='$nome', endereço='$endereço', horario='$horario', img=$img)"
    }
}