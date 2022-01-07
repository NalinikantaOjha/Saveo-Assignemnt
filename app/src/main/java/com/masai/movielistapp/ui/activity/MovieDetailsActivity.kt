package com.masai.movielistapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.masai.movielistapp.R
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    private var title:String = ""
    private var Desc:String=""
    private var Date:String=""
    private var Language:String=""
    private var image:String=""
    private var vote:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val intent=intent
        vote=intent.getStringExtra("vote").toString()
        title= intent.getStringExtra("title").toString()
        Desc=intent.getStringExtra("desc").toString()
        Date=intent.getStringExtra("release").toString()
        Language=intent.getStringExtra("language").toString()
        image=intent.getStringExtra("image").toString()

        Glide.with(ivDetailsImage).load("https://image.tmdb.org/t/p/w500$image")
            .into(ivDetailsImage)
        tvTitle.text = title
        tvLanguage.text = Language
        tvDate.text = Date
        tvDescription.text = Desc
    }
}