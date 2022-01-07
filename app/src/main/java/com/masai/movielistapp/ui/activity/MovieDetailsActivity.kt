package com.masai.movielistapp.ui.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.masai.movielistapp.R
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MovieDetailsActivity : AppCompatActivity() {
    var title:String = ""
    var Desc:String=""
    var Date:String=""
    var Language:String=""
    var image:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val intent=intent
        title= intent.getStringExtra("title").toString()
        Desc=intent.getStringExtra("desc").toString()
        Date=intent.getStringExtra("release").toString()
        Language=intent.getStringExtra("language").toString()
        image=intent.getStringExtra("image").toString()
        Glide.with(ivDetailsImage).load("https://image.tmdb.org/t/p/w500" + image)
            .into(ivDetailsImage)
        tvTitle.setText(title)
        tvLanguage.setText(Language)
        tvDate.setText(Date)
        tvDescription.setText(Desc)

    }
}