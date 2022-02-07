package com.tannatsri.mvvmappp.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tannatsri.mvvmappp.R
import com.tannatsri.mvvmappp.data.OrderData
import com.tannatsri.mvvmappp.data.OrderDetails

import com.tannatsri.mvvmappp.databinding.PayoutCardviewBinding
import com.tannatsri.mvvmappp.resources.BaseViewBinder
import com.tannatsri.mvvmappp.viewmodel.MainActivityViewModel

class PayoutCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: PayoutCardviewBinding = PayoutCardviewBinding.bind(itemView)
    fun updateView(data: MainActivityViewModel.PayoutAdapterView.PayoutCard) {
        with(binding) {

            binding.cardTitle.text = data.data.title
            binding.subHeadingText.text = data.data.order_summary
        }
    }

    companion object {
        const val TITLE_ITEM = 300
    }

    class PayoutCardViewBinder() : BaseViewBinder<MainActivityViewModel.PayoutAdapterView.PayoutCard, PayoutCardViewHolder>(
        MainActivityViewModel.PayoutAdapterView.PayoutCard::class.java
    ) {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.payout_cardview, parent, false)
            return PayoutCardViewHolder(itemView)
        }

        override fun bindViewHolder(model: MainActivityViewModel.PayoutAdapterView.PayoutCard, viewHolder: PayoutCardViewHolder) {
            viewHolder.updateView(model)
        }

        override fun getViewType(): Int {
            return TITLE_ITEM
        }

        override fun areItemsTheSame(oldItem: MainActivityViewModel.PayoutAdapterView.PayoutCard, newItem: MainActivityViewModel.PayoutAdapterView.PayoutCard): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MainActivityViewModel.PayoutAdapterView.PayoutCard, newItem: MainActivityViewModel.PayoutAdapterView.PayoutCard): Boolean {
            return oldItem == newItem
        }
    }
}