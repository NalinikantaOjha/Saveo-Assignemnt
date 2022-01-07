package com.masai.movielistapp.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.masai.movielistapp.data2.Result
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.movielistapp.R
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.item_layout2.view.*


class MovieAdapter :
    PagingDataAdapter<Result, MovieAdapter.MovieViewHolder>(diffCallback = diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val resultsDTO = getItem(position)
        holder.setData(resultsDTO!!)
    }

    class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(resultsDTO: Result) {
            view.apply {
                Glide.with(ivImageView).load("https://image.tmdb.org/t/p/w500" + resultsDTO.posterPath)
                    .into(ivImageView)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Result, newItem: Result) =
                oldItem.equals(newItem)
        }
    }


}