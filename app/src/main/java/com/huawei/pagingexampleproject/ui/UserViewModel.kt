package com.huawei.pagingexampleproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.huawei.pagingexampleproject.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 11/10/2021.
 */
@HiltViewModel
class UserViewModel @Inject constructor(userRepository: UserRepository) : ViewModel() {
    val userItemsUiStates = userRepository.getUsers()
        .map { pagingData ->
            pagingData.map { userModel -> UserItemUiState(userModel) }
        }.cachedIn(viewModelScope)
}
