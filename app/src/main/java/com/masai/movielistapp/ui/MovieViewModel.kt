package com.masai.movielistapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.masai.movielistapp.data.MovieRepository
import com.masai.movielistapp.data2.ResponseDTO
import com.masai.movielistapp.data2.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    fun searchMovie(): LiveData<PagingData<Result>> {
        return movieRepository.getMovieResults()
    }
    fun searchMovie2():LiveData<ResponseDTO> {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.getData()
        }
        return movieRepository.user
    }

}