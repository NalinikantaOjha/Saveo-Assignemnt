package com.masai.movielistapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.masai.movielistapp.R
import com.masai.movielistapp.ui.adapter.MovieAdaperViewPager
import com.masai.movielistapp.ui.adapter.MovieAdapterRecycler
import com.masai.movielistapp.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()
    private lateinit var movieAdapterRecycler: MovieAdapterRecycler
    private lateinit var movieAdapterViewPager: MovieAdaperViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecycleview()
        setViewPager()

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
        movieAdapterViewPager= MovieAdaperViewPager()
        viewPager5.apply {
            this.adapter=movieAdapterViewPager
        }
    }

    fun setRecycleview() {
        movieAdapterRecycler = MovieAdapterRecycler()
        val linearLayoutManager = GridLayoutManager(this,3)
        recyclerview.apply {
            layoutManager = linearLayoutManager
            this.adapter = movieAdapterRecycler
        }
    }
}