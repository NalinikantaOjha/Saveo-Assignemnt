package com.masai.movielistapp.data.api

import com.masai.movielistapp.data.model.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val BASE_URL = "http://api.themoviedb.org/"

    }
    @GET("3/discover/movie?api_key=328c283cd27bd1877d9080ccb1604c91")
    suspend fun getMovieByPage(@Query("page") page: Int): ResponseDTO


}