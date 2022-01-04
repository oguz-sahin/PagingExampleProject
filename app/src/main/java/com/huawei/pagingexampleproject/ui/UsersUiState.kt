package com.huawei.pagingexampleproject.ui

import android.content.Context
import android.view.View
import androidx.paging.LoadState
import com.huawei.pagingexampleproject.R

/**
 * Created by Oguz Sahin on 11/11/2021.
 */
data class UsersUiState(
    private val loadState: LoadState
) {

    fun getProgressBarVisibility() = if (loadState is LoadState.Loading) View.VISIBLE else View.GONE

    fun getListVisibility() = if (loadState is LoadState.NotLoading) View.VISIBLE else View.GONE

    fun getErrorVisibility() = if (loadState is LoadState.Error) View.VISIBLE else View.GONE

    fun getErrorMessage(context: Context) = if (loadState is LoadState.Error) {
        loadState.error.localizedMessage ?: context.getString(R.string.something_went_wrong)
    } else ""
}