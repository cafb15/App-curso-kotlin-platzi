package com.example.user.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_description.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        iv_product_detail.setImageDrawable(ContextCompat.getDrawable(this@DetailActivity, R.drawable.shop))

        intent.extras?.let {
            title_detail.text = it.getString("title")
            description_detail.text = it.getString("description")
            price_detail.text = "$ ${String.format("%.2f", it.getDouble("price"))}"
        }
    }
}