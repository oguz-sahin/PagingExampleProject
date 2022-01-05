package com.huawei.pagingexampleproject.ui

import android.content.Context
import androidx.paging.LoadState
import com.huawei.pagingexampleproject.R
import com.huawei.pagingexampleproject.common.BaseUiState

/**
 * Created by Oguz Sahin on 11/11/2021.
 */
data class UsersUiState(
    private val loadState: LoadState
) : BaseUiState() {

    fun getProgressBarVisibility() = getViewVisibility(isVisible = loadState is LoadState.Loading)

    fun getListVisibility() = getViewVisibility(isVisible = loadState is LoadState.NotLoading)

    fun getErrorVisibility() = getViewVisibility(isVisible = loadState is LoadState.Error)

    fun getErrorMessage(context: Context) = if (loadState is LoadState.Error) {
        loadState.error.localizedMessage ?: context.getString(R.string.something_went_wrong)
    } else ""
}