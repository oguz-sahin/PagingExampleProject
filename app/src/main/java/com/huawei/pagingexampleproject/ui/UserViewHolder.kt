package com.huawei.pagingexampleproject.ui

import androidx.recyclerview.widget.RecyclerView
import com.huawei.pagingexampleproject.databinding.ItemUserBinding

/**
 * Created by Oguz Sahin on 11/11/2021.
 */
class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(userItemUiState: UserItemUiState) {
        with(binding) {
            this.userItemUiState = userItemUiState
            executePendingBindings()
        }
    }
}