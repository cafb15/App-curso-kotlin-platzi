package com.example.user.platzistore

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class itemList : AnkoComponent<adaptadorCarrito> {

    override fun createView(ui: AnkoContext<adaptadorCarrito>): View = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            cardView {
                linearLayout {
                    lparams(width = matchParent)
                    orientation = LinearLayout.HORIZONTAL

                    imageView(R.mipmap.ic_launcher) {
                        id = R.id.image_item
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }.lparams(width = dip(0), height = dip(100), weight = 1F)

                    linearLayout {
                        padding = dip(5)
                        orientation = LinearLayout.VERTICAL
                        textView()
                    }
                }
            }
        }
    }
}