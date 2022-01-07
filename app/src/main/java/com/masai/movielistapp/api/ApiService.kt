package com.masai.movielistapp.api

import com.masai.movielistapp.data2.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        val BASE_URL = "http://api.themoviedb.org/"
    }
    @GET("3/discover/movie?api_key=328c283cd27bd1877d9080ccb1604c91")
    suspend fun getMovieByPage(@Query("page") page: Int): ResponseDTO
    @GET("3/discover/movie?api_key=328c283cd27bd1877d9080ccb1604c91")
    suspend fun getMovieByPage2(@Query("page") page: Int): Response<ResponseDTO>

}