package com.huawei.pagingexampleproject.util.ext

import androidx.databinding.ViewDataBinding

/**
 * Created by Oguz Sahin on 1/5/2022.
 */


fun <T : ViewDataBinding> T.executeWithAction(action: T.() -> Unit) {
    action()
    executePendingBindings()
}
