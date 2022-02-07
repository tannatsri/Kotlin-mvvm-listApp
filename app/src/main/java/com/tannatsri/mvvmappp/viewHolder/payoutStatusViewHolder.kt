package com.tannatsri.mvvmappp.viewHolder


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tannatsri.mvvmappp.R
import com.tannatsri.mvvmappp.data.OrderStatus
import com.tannatsri.mvvmappp.databinding.OrderDetailsBinding
import com.tannatsri.mvvmappp.resources.BaseViewBinder
import com.tannatsri.mvvmappp.viewmodel.MainActivityViewModel

class PayoutStatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: OrderDetailsBinding = OrderDetailsBinding.bind(itemView)


    fun updateView(data: MainActivityViewModel.PayoutAdapterView.PayoutStatus) {
        with(binding) {
 
            binding.title.text = data.data.title
            binding.refreshButton.text =  data.data.button_text
            binding.message.text = data.data.message


        }
    }

    companion object {
        const val TITLE_ITEM = 301
    }

    class PayoutStatusViewBinder() : BaseViewBinder<MainActivityViewModel.PayoutAdapterView.PayoutStatus, PayoutStatusViewHolder>(
        MainActivityViewModel.PayoutAdapterView.PayoutStatus::class.java
    ) {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.order_details, parent, false)
            return PayoutStatusViewHolder(itemView)
        }

        override fun bindViewHolder(model: MainActivityViewModel.PayoutAdapterView.PayoutStatus, viewHolder: PayoutStatusViewHolder) {
            viewHolder.updateView(model)
        }

        override fun getViewType(): Int {
            return TITLE_ITEM
        }

        override fun areItemsTheSame(oldItem: MainActivityViewModel.PayoutAdapterView.PayoutStatus, newItem: MainActivityViewModel.PayoutAdapterView.PayoutStatus): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MainActivityViewModel.PayoutAdapterView.PayoutStatus, newItem: MainActivityViewModel.PayoutAdapterView.PayoutStatus): Boolean {
            return false
        }
    }
}