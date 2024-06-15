package com.example.netflix

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder (myView: View): RecyclerView.ViewHolder(myView){

    val image: ImageView
    val title: TextView
    val type: TextView
   // val addToRoom: ImageButton

    init {
        image=myView.findViewById(R.id.newsImg)
        title=myView.findViewById(R.id.newsTitle)
        type=myView.findViewById(R.id.newsDisc)
       // addToRoom=myView.findViewById(R.id.addToRoom)
    }

}