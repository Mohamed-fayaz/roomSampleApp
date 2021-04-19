package com.example.guideapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordViewAdapter (private val context : Context?, private val words : List<Word>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.wordrvlayout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        val titleTV = holder.itemView.findViewById<TextView>(R.id.text)
        titleTV.text = words[position].word

    }

    override fun getItemCount(): Int {
        return words.size
    }
    class ViewHolder(v: View?): RecyclerView.ViewHolder(v!!){

        val title = itemView.findViewById<TextView>(R.id.text)

    }

}