package com.example.desafiointegrador2

import java.io.Serializable

class Usuario constructor(var nome: String? = null, var email: String, var senha: String): Serializable{

    override fun toString(): String {
        return "Usuario(nome='$nome', email='$email', senha='$senha')"
    }
}