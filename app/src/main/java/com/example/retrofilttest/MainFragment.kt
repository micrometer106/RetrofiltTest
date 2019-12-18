package com.example.retrofilttest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
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

        var foldView = view.findViewById<ConstraintLayout>(R.id.collection_fold_layout)
        val unfoldView = view.findViewById<ConstraintLayout>(R.id.collection_filter_layout)

        var arrow = view.findViewById<ImageView>(R.id.icon_fold_arrow)
        arrow.setOnClickListener(View.OnClickListener {
            foldView.visibility = if (foldView.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
            unfoldView.visibility = if (unfoldView.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
        })

        return view
    }
}