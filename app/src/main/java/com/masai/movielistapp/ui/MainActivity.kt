package com.masai.movielistapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.masai.movielistapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecycleview()
        movieViewModel.searchResults().observe(this, {
            lifecycleScope.launch {
                it?.let {
                    movieAdapter.submitData(lifecycle, it)
                }
            }
        })
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