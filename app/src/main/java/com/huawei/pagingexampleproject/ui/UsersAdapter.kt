package com.huawei.pagingexampleproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.huawei.pagingexampleproject.R
import com.huawei.pagingexampleproject.databinding.ItemUserBinding
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 11/10/2021.
 */
class UsersAdapter @Inject constructor() :
    PagingDataAdapter<UserItemUiState, UserViewHolder>(Comparator) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let { userItemUiState -> holder.bind(userItemUiState) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val binding = inflate<ItemUserBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_user,
            parent,
            false
        )

        return UserViewHolder(binding)
    }

    object Comparator : DiffUtil.ItemCallback<UserItemUiState>() {
        override fun areItemsTheSame(oldItem: UserItemUiState, newItem: UserItemUiState): Boolean {
            return oldItem.getPhone() == newItem.getPhone()
        }

        override fun areContentsTheSame(
            oldItem: UserItemUiState,
            newItem: UserItemUiState
        ): Boolean {
            return oldItem == newItem
        }
    }

}