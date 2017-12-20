package com.example.user.platzistore

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_landing.view.*

class LandingAdapter(private val items: List<Item>) : RecyclerView.Adapter<LandingAdapter.LandingViewHolder>() {

    class LandingViewHolder(view: View?) : RecyclerView.ViewHolder(view) {

        fun bindView(item: Item) {
            with(item) {
                itemView.title_item.text = title
                itemView.description_item.text = description
                itemView.price_item.text = "$ ${String.format("%.2f", price)}"

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("title", title)
                    intent.putExtra("description", description)
                    intent.putExtra("price", price)

                    val p1: Pair<View, String> = Pair.create(itemView.image_header, "transitionHeader")
                    val p2: Pair<View, String> = Pair.create(itemView.title_item, "transitionTitle")
                    val p3: Pair<View, String> = Pair.create(itemView.description_item, "transitionDesc")
                    val p4: Pair<View, String> = Pair.create(itemView.price_item, "transitionPrice")
                    val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, p1, p2, p3, p4)
                    itemView.context.startActivity(intent, options.toBundle())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LandingViewHolder = LandingViewHolder(parent?.inflate(R.layout.item_landing))

    override fun onBindViewHolder(holder: LandingViewHolder?, position: Int) {
        holder?.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size
}