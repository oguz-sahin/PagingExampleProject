package com.huawei.pagingexampleproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.huawei.pagingexampleproject.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 11/10/2021.
 */
@HiltViewModel
class UserViewModel @Inject constructor(userRepository: UserRepository) : ViewModel() {
    val userItemsUiStates = userRepository.getUsers().cachedIn(viewModelScope)
}
