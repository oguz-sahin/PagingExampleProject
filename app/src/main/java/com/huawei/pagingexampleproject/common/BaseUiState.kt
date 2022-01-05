package com.huawei.pagingexampleproject.common

import android.view.View

/**
 * Created by Oguz Sahin on 1/5/2022.
 */
open class BaseUiState {
    fun getViewVisibility(isVisible: Boolean) = if (isVisible) View.VISIBLE else View.GONE
}