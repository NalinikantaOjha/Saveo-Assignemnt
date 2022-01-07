package com.masai.movielistapp.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.masai.movielistapp.R
import com.masai.movielistapp.data.model.Result
import com.masai.movielistapp.ui.adapter.MovieAdaperViewPager
import com.masai.movielistapp.ui.adapter.MovieAdapterRecycler
import com.masai.movielistapp.ui.adapter.OnClickMovie
import com.masai.movielistapp.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),OnClickMovie {

    private val movieViewModel by viewModels<MovieViewModel>()
    private lateinit var movieAdapterRecycler: MovieAdapterRecycler
    private lateinit var movieAdapterViewPager: MovieAdaperViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecycleview()
        setViewPager()
        scrollView1.setBackgroundColor(Color.DKGRAY)
        relative1.setBackgroundColor(Color.DKGRAY)
        tvNowShowing.setBackgroundColor(Color.DKGRAY)

        movieViewModel.searchMovie3().observe(this, {
            lifecycleScope.launch {
                it?.let {
                   movieAdapterViewPager.submitData(lifecycle,it)
                }
            }
        })
        movieViewModel.searchMovie().observe(this, {
            lifecycleScope.launch {
                it?.let {
                    movieAdapterRecycler.submitData(lifecycle, it)
                }
            }
        })
    }

   fun setViewPager(){
        movieAdapterViewPager= MovieAdaperViewPager(this)
        viewPager5.clipToPadding = false
        viewPager5.clipChildren = false
        viewPager5.offscreenPageLimit=3
        viewPager5.apply {
            this.adapter=movieAdapterViewPager

        }
    }

    fun setRecycleview() {
        movieAdapterRecycler = MovieAdapterRecycler(this)
        val linearLayoutManager = GridLayoutManager(this,3)
        recyclerview.apply {
            layoutManager = linearLayoutManager
            this.adapter = movieAdapterRecycler
        }
    }

    override fun onClickMovie(result: Result) {
        val intent=Intent(this,MovieDetailsActivity::class.java)
        intent.putExtra("title",result.title)
        intent.putExtra("desc",result.overview)
        intent.putExtra("release",result.releaseDate)
        intent.putExtra("language",result.originalLanguage)



        startActivity(intent)
    }
}