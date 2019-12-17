package com.example.retrofilttest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerAdapter constructor(list : List<PostResp>) :
    RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {

    private lateinit var mList : List<PostResp>;

    init {
        mList = list
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mList.get(position)
        holder.mId.setText(data.id.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_layout, parent, false)
        var viewHolder = MainViewHolder(view)
        viewHolder.mId = view.findViewById(R.id.text_id)
        return viewHolder
    }

    class MainViewHolder : RecyclerView.ViewHolder {
        lateinit var mId : TextView

        constructor(itemView : View) : super(itemView)
    }
}