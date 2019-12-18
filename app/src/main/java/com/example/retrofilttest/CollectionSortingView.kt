package com.example.retrofilttest

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout

class CollectionSortingView(context : Context, attrs : AttributeSet? = null, defStyleAttr : Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet? = null) : this(context, attrs, 0)

    init {
        LayoutInflater.from(context).inflate(R.layout.collection_layout, this, true)
    }
}