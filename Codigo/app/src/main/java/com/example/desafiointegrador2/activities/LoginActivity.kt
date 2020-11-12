package com.example.desafiointegrador2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiointegrador2.R
import com.example.desafiointegrador2.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var cadastrado: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Click in button login
        btn_login.setOnClickListener{

            if ( cadastrado ) {
                callMain(getInformationUser())
            } else {
                showSnack("Faça um cadastro primeiro!")
            }
        }

        //clicando no botão cadastrar
        btn_cadastro.setOnClickListener{
            callCadastro()
        }
    }

    //Pega as informações do usuario
    fun getInformationUser(): Usuario {
        val email = edEmail.text.toString()
        val senha = edPassword.text.toString()

        return Usuario(null, email, senha)
    }

    //Chamando a MainActivity
    fun callMain(usuario: Usuario){
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("key", usuario)
        startActivity(intent)
    }

    //Chamando a CadastroActivity
    fun callCadastro(){
        var intent = Intent(this, CadastroActivity::class.java)
        cadastrado = true
        startActivity(intent)
    }

    fun showSnack(msg: String) {
        var snack = Snackbar.make(act_login, msg, Snackbar.LENGTH_SHORT).show()
    }
}