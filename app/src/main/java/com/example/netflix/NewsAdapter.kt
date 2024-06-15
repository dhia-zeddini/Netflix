package com.example.netflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter (val news:MutableList<DataMovie>): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.single_item, parent, false) as View
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  news.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.title.text=news[position].name
        holder.type.text=news[position].type
        holder.image.setImageResource( news[position].image)
    }
}