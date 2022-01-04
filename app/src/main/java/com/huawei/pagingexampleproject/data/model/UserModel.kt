package com.huawei.pagingexampleproject.data.model

/**
 * Created by Oguz Sahin on 11/10/2021.
 */
data class UserModel(
    val name: NameModel,
    val email: String,
    val phone: String,
    val picture: PictureModel
)
