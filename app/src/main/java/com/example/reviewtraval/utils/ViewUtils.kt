package com.example.reviewtraval.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.load(imagUrl : String){
    Picasso.get().load(imagUrl).into(this)
}