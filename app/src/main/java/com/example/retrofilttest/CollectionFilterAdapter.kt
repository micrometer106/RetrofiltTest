package com.example.retrofilttest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CollectionFilterAdapter constructor(list : List<String>) : RecyclerView.Adapter<CollectionFilterAdapter.CollectionViewHolder>() {

    private lateinit var mList : List<String>

    init {
        mList = list
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.collection_element_layout, parent, false)
        val viewHolder = CollectionViewHolder(view)
        viewHolder.mTitle = view.findViewById<TextView>(R.id.element_title)
        return viewHolder
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.mTitle.setText(mList.get(position))
    }

    class CollectionViewHolder : RecyclerView.ViewHolder {
        lateinit var mTitle : TextView

        constructor(itemView : View) : super(itemView)
    }
}