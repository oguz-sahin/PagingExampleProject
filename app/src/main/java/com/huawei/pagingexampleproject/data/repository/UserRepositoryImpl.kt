package com.huawei.pagingexampleproject.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.huawei.pagingexampleproject.data.model.UserModel
import com.huawei.pagingexampleproject.data.pagingdatasource.UserPagingDataSource
import com.huawei.pagingexampleproject.network.UserService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Oguz Sahin on 11/10/2021.
 */

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {
    override fun getUsers(): Flow<PagingData<UserModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { UserPagingDataSource(userService) }
        ).flow
    }
}