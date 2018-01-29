package com.example.user.platzistore

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class adaptadorCarrito(val data: List<ItemListPOJO>) : RecyclerView.Adapter<adaptadorCarrito.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val textViewTitle by lazy {
            itemView.find<TextView>(R.id.text_title_item)
        }

        private val textViewDescription by lazy {
            itemView.find<TextView>(R.id.text_desc_item)
        }

        private val textViewPrice by lazy {
            itemView.find<TextView>(R.id.text_price_item)
        }

        fun bindView(itemListPOJO: ItemListPOJO) {
            with(itemListPOJO) {
                textViewTitle.text = title
                textViewDescription.text = description
                textViewPrice.text = price
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        return Holder(itemList().createView(AnkoContext.Companion.create(parent!!.context, this, false)))
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size
}