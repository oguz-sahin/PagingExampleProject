package com.huawei.pagingexampleproject.common

import android.content.Context
import android.view.View
import androidx.paging.LoadState
import com.huawei.pagingexampleproject.R

/**
 * Created by Oguz Sahin on 11/11/2021.
 */
data class FooterUiState(private val loadState: LoadState) {

    fun getLoadingVisibility() = if (loadState is LoadState.Loading) View.VISIBLE else View.GONE

    fun getErrorVisibility() = if (loadState is LoadState.Error) View.VISIBLE else View.GONE

    fun getErrorMessage(context: Context) = if (loadState is LoadState.Error) {
        loadState.error.localizedMessage ?: context.getString(R.string.something_went_wrong)
    } else ""
}
