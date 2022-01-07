package com.masai.movielistapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.movielistapp.R
import com.masai.movielistapp.data2.Result

class ViewPagerAdapter(
    var list: MutableList<Result>,
    var context: Context
) : RecyclerView.Adapter<ViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.item_layout2, parent, false)
        return ViewPagerViewHolder(view1)
    }

    override fun onBindViewHolder(holderViewPager: ViewPagerViewHolder, position: Int) {
        val type = list.get(position)
        holderViewPager.setData(type)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}