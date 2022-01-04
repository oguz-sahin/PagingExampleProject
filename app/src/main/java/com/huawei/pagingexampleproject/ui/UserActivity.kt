package com.huawei.pagingexampleproject.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.huawei.pagingexampleproject.R
import com.huawei.pagingexampleproject.common.FooterAdapter
import com.huawei.pagingexampleproject.databinding.ActivityUserBinding
import com.huawei.pagingexampleproject.util.ext.collect
import com.huawei.pagingexampleproject.util.ext.collectLast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AndroidEntryPoint
class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private val viewModel: UserViewModel by viewModels()

    @Inject
    lateinit var userAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setListener()
        setAdapter()
        collectLast(viewModel.userItemsUiStates, ::setUsers)
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)
    }

    private fun setListener() {
        binding.btnRetry.setOnClickListener { userAdapter.retry() }
    }


    private fun setAdapter() {
        collect(flow = userAdapter.loadStateFlow
            .distinctUntilChangedBy { it.source.refresh }
            .map { it.refresh },
            action = ::setUsersUiState
        )
        binding.rvUsers.adapter = userAdapter.withLoadStateFooter(FooterAdapter(userAdapter::retry))
    }

    private fun setUsersUiState(loadState: LoadState) {
        with(binding) {
            usersUiState = UsersUiState(loadState)
            executePendingBindings()
        }
    }

    private suspend fun setUsers(userItemsPagingData: PagingData<UserItemUiState>) {
        userAdapter.submitData(userItemsPagingData)
    }

}