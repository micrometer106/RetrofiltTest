package com.example.retrofilttest

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CollectionSortingView(context : Context, attrs : AttributeSet? = null, defStyleAttr : Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet? = null) : this(context, attrs, 0)

    var mCountryList = listOf<String>("Taiwan", "Korea", "Japan", "China", "Tai")
    var mThemeList = listOf<String>("All", "Romance", "Horror", "Free", "Food", "Music", "Travel", "Society")

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.collection_filter_layout, this, true)

        val countryRecyclerView = view.findViewById<RecyclerView>(R.id.collection_country)
        countryRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        countryRecyclerView.adapter = CollectionFilterAdapter(mCountryList)

        val themeRecyclerView = view.findViewById<RecyclerView>(R.id.collection_theme)
        themeRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        themeRecyclerView.adapter = CollectionFilterAdapter(mThemeList)
    }
}