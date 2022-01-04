package com.huawei.pagingexampleproject.ui

import com.huawei.pagingexampleproject.data.model.UserModel

/**
 * Created by Oguz Sahin on 11/11/2021.
 */
data class UserItemUiState(private val userModel: UserModel) {

    fun getImageUrl() = userModel.picture.thumbnail

    fun getName() = "${userModel.name.first} ${userModel.name.last}"

    fun getPhone() = userModel.phone

    fun getMail() = userModel.email

}