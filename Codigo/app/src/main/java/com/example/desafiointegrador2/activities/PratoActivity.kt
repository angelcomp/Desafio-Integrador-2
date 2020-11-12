package com.example.desafiointegrador2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiointegrador2.Pratos
import com.example.desafiointegrador2.R
import kotlinx.android.synthetic.main.activity_prato.*

class PratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato)

        var prato = intent.getSerializableExtra("prato") as? Pratos

        if (prato != null) {
            tv_descricao.setText(prato.descricao)
        }

        setaVoltar.setOnClickListener {
            finish()
        }
    }
 }