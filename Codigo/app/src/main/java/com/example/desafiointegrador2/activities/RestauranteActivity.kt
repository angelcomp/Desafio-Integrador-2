package com.example.desafiointegrador2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafiointegrador2.R
import com.example.desafiointegrador2.Restaurante
import com.example.desafiointegrador2.Usuario
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)

        val extras = intent.extras
        var img = extras?.getInt("imagem")
        var nome = extras?.getString("nome")

        tv_nomeBackground.text = nome
        if (img != null) {
            iv_background.setImageResource(img)
        }

        seta.setOnClickListener {
            onBackPressed()
        }

        iv_background.setOnClickListener {
            Toast.makeText(this, "oin", Toast.LENGTH_LONG).show()
        }
    }
}
