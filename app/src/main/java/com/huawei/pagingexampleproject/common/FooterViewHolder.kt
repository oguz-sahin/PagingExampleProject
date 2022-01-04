package com.huawei.pagingexampleproject.common

import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.huawei.pagingexampleproject.databinding.ItemPagingFooterBinding

/**
 * Created by Oguz Sahin on 11/11/2021.
 */
class FooterViewHolder(
    private val binding: ItemPagingFooterBinding,
    retry: () -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.btnRetry.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        with(binding) {
            footerUiState = FooterUiState(loadState)
            executePendingBindings()
        }
    }
}