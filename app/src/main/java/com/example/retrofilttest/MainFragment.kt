package com.example.retrofilttest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment constructor(list : List<PostResp>) : Fragment() {

    private val TAG = MainFragment::class.java.simpleName
    private var mList : List<PostResp>

    init {
        mList = list
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(container?.context)
        var mainRecyclerAdapter = MainRecyclerAdapter(mList)
        recyclerView.adapter = mainRecyclerAdapter
        return view
    }
}