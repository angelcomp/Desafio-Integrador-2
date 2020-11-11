package com.example.desafiointegrador2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listaRestaurante: ArrayList<Restaurante>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var usuario = intent.getSerializableExtra("usuario") as? Usuario
        showToast("Bem Vindo ${usuario!!.nome}")

        listaRestaurante = getListRestaurantes()

    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    //retorna lista de restaurantes
    fun getListRestaurantes(): ArrayList<Restaurante> {
        return arrayListOf(
            Restaurante(
                "Tony Roma's",
                "Av. Lavandisca, 717 - Indianápolis, São Paulo",
                "Fecha às 22:00",
                R.drawable.image1
            ),
            Restaurante(
                "Aoyama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00",
                R.drawable.image4
            ),
            Restaurante(
                "Outback - Moema",
                "Av. Moaci, 187 - Moema, São Paulo",
                "Fecha às 00:00",
                R.drawable.image5
            ),
            Restaurante(
                "Sí señor!",
                "Alameda Jauaperi, 626 - Moema",
                "Fecha às 01:00",
                R.drawable.image3
            )
        )
    }
}