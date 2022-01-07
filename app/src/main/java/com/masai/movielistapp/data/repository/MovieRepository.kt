package com.masai.movielistapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.masai.movielistapp.data.api.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {
    fun getMovieResults() =
        Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {
                MovieSourceRecycler(apiService) }
        ).liveData

    fun getMovieResults2() =
        Pager(
            config = PagingConfig(
                pageSize = 3
            ),
            pagingSourceFactory = {
                MovieSourceViewPager(apiService) }
        ).liveData

}