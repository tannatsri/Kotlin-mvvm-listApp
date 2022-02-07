//package com.tannatsri.mvvmappp.viewHolder
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.constraintlayout.widget.ConstraintLayout
//import androidx.recyclerview.widget.RecyclerView
//import com.tannatsri.mvvmappp.R
//import com.tannatsri.mvvmappp.data.OrderData
//import com.tannatsri.mvvmappp.data.OrderDetails
//import com.tannatsri.mvvmappp.databinding.OrderDetailsBinding
//import com.tannatsri.mvvmappp.resources.BaseViewBinder
//
//class PayoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    private val binding: OrderDetailsBinding = OrderDetailsBinding.bind(itemView)
//
//
//    fun updateView(data: OrderData) {
//        with(binding) {
//            binding.cardOrderSummary.text = data.order_details.order_value + " \n" + data.order_details.share_value
//            binding.cardTitle.text = data.order_details.title
//            binding.subHeadingText.text = data.order_details.order_summary
//            binding.title.text = data.order_status.title
//            binding.message.text = data.order_status.message
//            binding.refreshButton.text = data.order_status.button_text
//            binding.homeButton.text = data.home_button_text
//        }
//    }
//
//    companion object {
//        const val TITLE_ITEM = 300
//    }
//
//    class PayoutViewBinder() : BaseViewBinder<OrderData, PayoutViewHolder>(
//        OrderData::class.java
//    ) {
//        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
//            val itemView =
//                LayoutInflater.from(parent.context).inflate(R.layout.order_details, parent, false)
//            return PayoutViewHolder(itemView)
//        }
//
//        override fun bindViewHolder(model: OrderData, viewHolder: PayoutViewHolder) {
//            viewHolder.updateView(model)
//        }
//
//        override fun getViewType(): Int {
//            return TITLE_ITEM
//        }
//
//        override fun areItemsTheSame(oldItem: OrderData, newItem: OrderData): Boolean {
//            return oldItem.order_details.order_value == newItem.order_details.order_value
//        }
//
//        override fun areContentsTheSame(oldItem: OrderData, newItem: OrderData): Boolean {
//            return oldItem.order_details.order_value == newItem.order_details.order_value
//        }
//    }
//}
