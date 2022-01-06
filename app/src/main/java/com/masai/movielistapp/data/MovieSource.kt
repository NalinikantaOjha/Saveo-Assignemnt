package com.masai.movielistapp.data
import com.masai.movielistapp.data2.Result
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.masai.movielistapp.api.ApiService
import com.masai.movielistapp.data2.ResponseDTO


class MovieSource(private val apiService: ApiService) :
    PagingSource<Int,Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,Result> {
        return try {
            val pageNumber = params.key ?: 1
            val response: ResponseDTO = apiService.getMovieByPage(pageNumber)
            val data = response.results as List<Result>
            LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = if (data!!?.isEmpty()) null else pageNumber + 1
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