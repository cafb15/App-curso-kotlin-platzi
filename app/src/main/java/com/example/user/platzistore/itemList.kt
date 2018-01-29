package com.example.user.platzistore

import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class itemList : AnkoComponent<adaptadorCarrito> {

    override fun createView(ui: AnkoContext<adaptadorCarrito>): View = with(ui) {
        cardView {
            lparams {
                width = matchParent
                height = wrapContent
                margin = dip(5)
            }
            verticalLayout {
                lparams(matchParent, wrapContent)

                imageView(R.mipmap.ic_launcher) {
                    id = R.id.image_item
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(matchParent, dip(100))

                verticalLayout {
                    lparams(matchParent, wrapContent)
                    padding = dip(10)

                    textView("Title") {
                        id = R.id.text_title_item
                        textAppearance = android.R.style.TextAppearance_Material_Large
                    }

                    textView("Description") {
                        id = R.id.text_desc_item
                        textAppearance = android.R.style.TextAppearance_Material_Small
                    }

                    textView("Price") {
                        id = R.id.text_price_item
                        textAppearance = android.R.style.TextAppearance_Material_Medium
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams {
                        gravity = Gravity.END
                    }
                }
            }
        }
    }
}