package com.huawei.pagingexampleproject.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.huawei.pagingexampleproject.R
import com.huawei.pagingexampleproject.databinding.ItemPagingFooterBinding

/**
 * Created by Oguz Sahin on 11/11/2021.
 */

class FooterAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<FooterViewHolder>() {
    override fun onBindViewHolder(holder: FooterViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): FooterViewHolder {
        val itemPagingFooterBinding = inflate<ItemPagingFooterBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_paging_footer,
            parent,
            false
        )
        return FooterViewHolder(itemPagingFooterBinding, retry)
    }

}

