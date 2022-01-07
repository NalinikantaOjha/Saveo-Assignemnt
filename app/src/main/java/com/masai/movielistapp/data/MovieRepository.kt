package com.masai.movielistapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.masai.movielistapp.api.ApiService
import com.masai.movielistapp.data2.ResponseDTO
import com.masai.movielistapp.data2.Result
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {
    fun getMovieResults() =
        Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = { MovieSource(apiService) }
        ).liveData

    private val userLiveData = MutableLiveData<ResponseDTO>()
    val user: LiveData<ResponseDTO>
        get() = userLiveData

    suspend fun getData() {
        val result = apiService.getMovieByPage2(1)
        if (result.body() != null) {
            userLiveData.postValue(result.body())

        }
    }
}