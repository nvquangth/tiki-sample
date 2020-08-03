package com.example.tikisample.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.example.tikisample.R
import com.example.tikisample.base.BaseRecyclerViewAdapter
import com.example.tikisample.data.model.QuickLinkItem
import com.example.tikisample.data.model.QuickLinkPair
import com.example.tikisample.databinding.ItemQuickLinkBinding

/**
 * Created by Quang Nguyen on 8/1/20.
 */
class QuickLinkAdapter(
    private val listener: ((QuickLinkItem?) -> Unit)? = null
) : BaseRecyclerViewAdapter<QuickLinkPair, ItemQuickLinkBinding>(object :
    DiffUtil.ItemCallback<QuickLinkPair>() {
    override fun areContentsTheSame(oldItem: QuickLinkPair, newItem: QuickLinkPair): Boolean = false

    override fun areItemsTheSame(oldItem: QuickLinkPair, newItem: QuickLinkPair): Boolean = false
}) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_quick_link

    override fun bindFirstTime(binding: ItemQuickLinkBinding) {
        super.bindFirstTime(binding)

        binding.apply {
            imageIcon1.setOnClickListener {
                setItemQuickLink1Click(this)
            }
            textQuickLink1.setOnClickListener {
                setItemQuickLink1Click(this)
            }

            imageIcon2.setOnClickListener {
                setItemQuickLink2Click(this)
            }
            textQuickLink2.setOnClickListener {
                setItemQuickLink2Click(this)
            }
        }
    }

    private fun setItemQuickLink1Click(binding: ItemQuickLinkBinding) {
        binding.item?.let { pair ->
            listener?.invoke(pair.quickLink1)
        }
    }

    private fun setItemQuickLink2Click(binding: ItemQuickLinkBinding) {
        binding.item?.let { pair ->
            listener?.invoke(pair.quickLink2)
        }
    }
}