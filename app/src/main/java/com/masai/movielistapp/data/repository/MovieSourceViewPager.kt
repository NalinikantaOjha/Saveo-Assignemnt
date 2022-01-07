package com.masai.movielistapp.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.masai.movielistapp.data.api.ApiService
import com.masai.movielistapp.data.model.ResponseDTO
import com.masai.movielistapp.data.model.Result

class MovieSourceViewPager(private val apiService: ApiService) :
    PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val pageNumber = params.key ?: 2
            val response: ResponseDTO = apiService.getMovieByPage(pageNumber)
            val data = response.results as List<Result>
            LoadResult.Page(
                data = data,
                prevKey = null,

                nextKey = if (data.isEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}