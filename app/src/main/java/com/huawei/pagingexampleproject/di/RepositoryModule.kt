package com.huawei.pagingexampleproject.di

import com.huawei.pagingexampleproject.data.repository.UserRepository
import com.huawei.pagingexampleproject.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Oguz Sahin on 11/10/2021.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserRepository(userRepository: UserRepositoryImpl): UserRepository
}