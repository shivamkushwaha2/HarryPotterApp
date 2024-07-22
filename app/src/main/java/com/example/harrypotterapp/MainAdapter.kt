package com.example.harrypotterapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView

class MainAdapter(items: MutableList<character>, mainActivity: MainActivity) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

val Totalitems = items
    val context = mainActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  Totalitems.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       val currentItem = Totalitems[position]
        holder.name.text = currentItem.fullName
        val fname = currentItem.fullName
        holder.card.setOnClickListener {
            Toast.makeText(context, fname, Toast.LENGTH_SHORT).show()
        }
        Glide.with(context).load( currentItem.image).into(holder.image)

    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        val image = itemView.findViewById<ImageView>(R.id.image)
        val card = itemView.findViewById<MaterialCardView>(R.id.card)

    }
}