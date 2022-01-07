package com.masai.movielistapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.masai.movielistapp.R
import com.masai.movielistapp.data2.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()
    private lateinit var movieAdapter: MovieAdapter
    private var List = mutableListOf<Result>()

    private lateinit var viewPagerAdapter5: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecycleview()
        setViewPager()
        movieViewModel.searchMovie2().observe(this,){
            List.clear()
            List.addAll(it.results as MutableList<Result>)
            viewPagerAdapter5.notifyDataSetChanged()
        }
        movieViewModel.searchMovie().observe(this, {
            lifecycleScope.launch {
                it?.let {
                    movieAdapter.submitData(lifecycle, it)
                }
            }
        })
    }
    fun setViewPager(){
        viewPagerAdapter5 = ViewPagerAdapter(List, this)
        viewPager5.apply {
            this.adapter=viewPagerAdapter5
        }
    }

    fun setRecycleview() {
        movieAdapter = MovieAdapter()
        val linearLayoutManager = GridLayoutManager(this,3)
        recyclerview.apply {
            layoutManager = linearLayoutManager
            this.adapter = movieAdapter
        }
    }
}