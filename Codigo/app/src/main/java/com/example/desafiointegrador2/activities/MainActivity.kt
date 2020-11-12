package com.example.desafiointegrador2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiointegrador2.R
import com.example.desafiointegrador2.Restaurante
import com.example.desafiointegrador2.RestauranteAdapter
import com.example.desafiointegrador2.Usuario
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    RestauranteAdapter.onRestClickListener {

    var listaRestaurante = getListRestaurantes()
    var adapter = RestauranteAdapter(listaRestaurante, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var usuario = intent.getSerializableExtra("usuario") as? Usuario
        showToast("Bem-Vindo(a) ${usuario!!.nome}")

        rvRestaurante.adapter = adapter
        rvRestaurante.layoutManager = LinearLayoutManager(this)
        rvRestaurante.setHasFixedSize(true)
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    //retorna lista de restaurantes
    fun getListRestaurantes(): ArrayList<Restaurante> {
        return arrayListOf(
            Restaurante(
                1,
                "Tony Roma's",
                "Av. Lavandisca, 717 - Indianápolis, São Paulo",
                "Fecha às 22:00",
                R.drawable.image1
            ),
            Restaurante(
                2,
                "Aoyama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00",
                R.drawable.image4
            ),
            Restaurante(
                3,
                "Outback - Moema",
                "Av. Moaci, 187 - Moema, São Paulo",
                "Fecha às 00:00",
                R.drawable.image6
            ),
            Restaurante(
                4,
                "Sí señor!",
                "Alameda Jauaperi, 626 - Moema",
                "Fecha às 01:00",
                R.drawable.image3
            )
        )
    }

    override fun restClick(position: Int) {

        callRest(position)

        //var res = listaRestaurante.get(position)
        //res.nome = "DEU CERTO! YEY >.<"

        //adapter.notifyItemChanged(position)
        //Toast.makeText(this, res.nome, Toast.LENGTH_LONG).show()
    }

    fun callRest(position: Int){
        var intent = Intent(this, RestauranteActivity::class.java)
        var res = listaRestaurante.get(position)

        intent.putExtra("imagem", res.img)
        intent.putExtra("nome", res.nome)

        startActivity(intent)
    }
}