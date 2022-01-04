package com.huawei.pagingexampleproject.data.pagingdatasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.huawei.pagingexampleproject.data.model.UserModel
import com.huawei.pagingexampleproject.network.UserService

/**
 * Created by Oguz Sahin on 11/10/2021.
 */


class UserPagingDataSource(private val userService: UserService) :
    PagingSource<Int, UserModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = userService.getUsers(page, params.loadSize)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

}
