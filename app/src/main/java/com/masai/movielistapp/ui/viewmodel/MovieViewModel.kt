package com.masai.movielistapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.masai.movielistapp.data.repository.MovieRepository
import com.masai.movielistapp.data.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    fun searchMovie(): LiveData<PagingData<Result>> {
        return movieRepository.getMovieResults()
    }
    fun searchMovie3(): LiveData<PagingData<Result>> {
        return movieRepository.getMovieResults2()
    }


}