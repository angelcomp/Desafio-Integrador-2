package com.example.desafiointegrador2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiointegrador2.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_restaurante.*
import kotlinx.android.synthetic.main.item_prato.*

class RestauranteActivity : AppCompatActivity(), PratosAdapter.onRestClickListener{

    private var listaPratos: ArrayList<Pratos> = getListaPratos()
    var adapter = PratosAdapter(listaPratos, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)

        //val extras = intent.extras
        var rest = (intent.getSerializableExtra("restaurante") as? Restaurante)!!

        tv_nomeBackground.text = rest.nome
        if (rest.img != null) {
            iv_background.setImageResource(rest.img)
        }

        seta.setOnClickListener {
            finish()
        }

        iv_background.setOnClickListener {
            Toast.makeText(this, "oin", Toast.LENGTH_LONG).show()
        }

        rv_pratos.adapter = adapter
        rv_pratos.layoutManager = GridLayoutManager(this,2)
        rv_pratos.setHasFixedSize(true)
    }

    fun getListaPratos(): ArrayList<Pratos> {

        var lista: ArrayList<Pratos> = arrayListOf()
        for (i in 1.. 16) {
            lista.add(Pratos("Salada com Molho de Gengibre", R.drawable.image4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque non hendrerit sapien. Pellentesque ex lorem, auctor ac diam vitae, tincidunt eleifend erat. Phasellus quis condimentum ex, et hendrerit arcu. Morbi quis porttitor arcu."))
        }
        return lista
    }

    override fun pratoClick(position: Int) {
        callPrato(position)
    }

    fun callPrato(position: Int){
        var intent = Intent(this, PratoActivity::class.java)
        var prato = listaPratos.get(position)

        intent.putExtra("prato", prato)

        startActivity(intent)
    }

}
