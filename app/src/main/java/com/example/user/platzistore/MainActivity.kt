package com.example.user.platzistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //without Android Extensions
//        val text: TextView = findViewById(R.id.id)
        setSupportActionBar(t_list)

        //with Android Extensions
        recycler_landing.layoutManager = GridLayoutManager(this@MainActivity, 2)

        val items = (0..20).map { ItemListPOJO("Title $it", "Description $it", "200") }
        val itemsShop = (0..20).map { Item("Title $it", "Description $it", 200.00 + it) }

        val adapterPOJO = adaptadorCarrito(items)
        val adapter = LandingAdapter(itemsShop)
        recycler_landing.adapter = adapter

//        id.setOnClickListener {
//            startActivity<DetailActivity>("text" to "Hello from Anko")
//        }
    }
}