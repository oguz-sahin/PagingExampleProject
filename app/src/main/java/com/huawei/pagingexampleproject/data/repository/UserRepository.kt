package com.huawei.pagingexampleproject.data.repository

import androidx.paging.PagingData
import com.huawei.pagingexampleproject.data.model.UserModel
import com.huawei.pagingexampleproject.ui.UserItemUiState
import kotlinx.coroutines.flow.Flow

/**
 * Created by Oguz Sahin on 11/10/2021.
 */

interface UserRepository {
   fun getUsers(): Flow<PagingData<UserItemUiState>>
}