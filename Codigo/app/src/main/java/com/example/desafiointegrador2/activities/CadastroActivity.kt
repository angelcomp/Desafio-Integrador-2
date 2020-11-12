package com.example.desafiointegrador2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiointegrador2.R
import com.example.desafiointegrador2.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_cadastro.act_login
import kotlinx.android.synthetic.main.activity_cadastro.edEmail
import kotlinx.android.synthetic.main.activity_cadastro.edPassword

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        iv_arrowBack.setOnClickListener {
            onBackPressed()
        }
        btn_registrar.setOnClickListener {

            callMain(getInformationUser())
        }
    }

    //Pega as informações do usuario
    fun getInformationUser(): Usuario {

        var username = edName.text.toString()
        var email = edEmail.text.toString()
        var senha = edPassword.text.toString()
        var senha2 = edPasswordConfere.text.toString()

        return Usuario(username, email, senha)
    }

    //Chamando MainActivity
    fun callMain(user: Usuario){
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("usuario", user)
        startActivity(intent)
    }

    fun showSnack(msg: String) {
        var snack = Snackbar.make(act_login, msg, Snackbar.LENGTH_SHORT).show()
    }

}