package com.masai.movielistapp.ui
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.movielistapp.data2.Result
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.item_layout2.view.*

class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(resultsDTO: Result) {

        itemView.apply {

            Glide.with(ivImageView2).load("https://image.tmdb.org/t/p/w500" + resultsDTO.posterPath)
                .into(ivImageView2)
        }

    }
}