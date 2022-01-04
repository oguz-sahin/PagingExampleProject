package com.huawei.pagingexampleproject.network

import com.huawei.pagingexampleproject.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Oguz Sahin on 11/10/2021.
 */
interface UserService {

    @GET(".")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("results") results: Int,
    ): UserResponse
}