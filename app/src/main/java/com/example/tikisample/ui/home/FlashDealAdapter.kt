package com.example.tikisample.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tikisample.BR
import com.example.tikisample.R
import com.example.tikisample.base.BaseViewHolder
import com.example.tikisample.data.model.FlashDeal
import com.example.tikisample.databinding.ItemFlashDealBinding
import com.example.tikisample.databinding.ItemFlashDealViewMoreBinding
import java.util.concurrent.Executors

/**
 * Created by Quang Nguyen on 8/2/20.
 */
class FlashDealAdapter(
    private val itemFlashDealClickListener: ((FlashDeal) -> Unit)? = null,
    private val itemViewMoreClickListener: (() -> Unit)? = null
) : ListAdapter<FlashDeal, RecyclerView.ViewHolder>(
    AsyncDifferConfig.Builder(object : DiffUtil.ItemCallback<FlashDeal>() {
        override fun areContentsTheSame(oldItem: FlashDeal, newItem: FlashDeal): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(oldItem: FlashDeal, newItem: FlashDeal): Boolean =
            oldItem.product?.id == newItem.product?.id
    })
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor()).build()
) {
    companion object {
        private const val FLASH_DEAL_TYPE = 1
        private const val VIEW_MORE_TYPE = 2
    }

    private var data = listOf<FlashDeal>()

    override fun getItemViewType(position: Int): Int = if (position == data.size - 1) {
        VIEW_MORE_TYPE
    } else {
        FLASH_DEAL_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == FLASH_DEAL_TYPE) {
            val binding = DataBindingUtil.inflate<ItemFlashDealBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_flash_deal,
                parent,
                false
            )
            return FlashDealViewHolder(binding).apply {
                binding.apply {
                    root.setOnClickListener {
                        item?.let {
                            itemFlashDealClickListener?.invoke(it)
                        }
                    }
                }
            }

        } else {
            val binding = DataBindingUtil.inflate<ItemFlashDealViewMoreBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_flash_deal_view_more,
                parent,
                false
            )
            return ViewMoreViewHolder(binding).apply {
                binding.apply {
                    root.setOnClickListener {
                        itemViewMoreClickListener?.invoke()
                    }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is FlashDealViewHolder) {
            val item = getItem(position)
            holder.binding.apply {
                setVariable(BR.item, item)
                executePendingBindings()
            }
        } else if (holder is ViewMoreViewHolder) {
            val item = getItem(position)
            holder.binding.apply {
                setVariable(BR.item, item)
                executePendingBindings()
            }
        }
    }

    override fun submitList(list: MutableList<FlashDeal>?) {
        list?.add(FlashDeal())
        data = list ?: listOf()
        super.submitList(ArrayList<FlashDeal>(data))
    }

    inner class FlashDealViewHolder(binding: ItemFlashDealBinding) :
        BaseViewHolder<ItemFlashDealBinding>(
            binding
        )

    inner class ViewMoreViewHolder(binding: ItemFlashDealViewMoreBinding) :
        BaseViewHolder<ItemFlashDealViewMoreBinding>(
            binding
        )
}