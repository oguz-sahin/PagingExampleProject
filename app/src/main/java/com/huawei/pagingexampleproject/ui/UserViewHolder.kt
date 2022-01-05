package com.huawei.pagingexampleproject.ui

import androidx.recyclerview.widget.RecyclerView
import com.huawei.pagingexampleproject.databinding.ItemUserBinding
import com.huawei.pagingexampleproject.util.ext.executeWithAction

/**
 * Created by Oguz Sahin on 11/11/2021.
 */
class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(userItemUiState: UserItemUiState) {
        binding.executeWithAction {
            this.userItemUiState = userItemUiState
        }
    }
}