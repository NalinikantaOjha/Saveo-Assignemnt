package com.masai.movielistapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.masai.movielistapp.data.MovieRepository
import com.masai.movielistapp.data2.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    fun searchResults(): LiveData<PagingData<Result>> {
        return movieRepository.getMovieResults()
    }
}