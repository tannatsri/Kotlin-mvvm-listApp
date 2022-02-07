package com.tannatsri.mvvmappp.resources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup





typealias ModelClass = Class<out Any>
typealias ViewBinder = BaseViewBinder<Any, RecyclerView.ViewHolder>


abstract class BaseViewBinder<M, in VH : RecyclerView.ViewHolder>(
    val model: Class<out M>
) : DiffUtil.ItemCallback<M>() {

    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun bindViewHolder(model: M, viewHolder: VH)
    abstract fun getViewType(): Int

    // Having these as non abstract because not all the viewBinders are required to implement them.
    open fun bindViewHolderWithPayload(model: M, viewHolder: VH, payload: Any) = Unit
    open fun onViewRecycled(viewHolder: VH) = Unit
    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit
    open fun onViewAttachedToWindow(viewHolder: VH) = Unit
}



internal class AdapterItemDiffCallback(
    private val viewBinders: Map<ModelClass, ViewBinder>
) : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (oldItem::class != newItem::class) {
            return false
        }
        return viewBinders[oldItem::class.java]?.areItemsTheSame(oldItem, newItem) ?: false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return viewBinders[oldItem::class.java]?.areContentsTheSame(oldItem, newItem) ?: false
    }

    override fun getChangePayload(oldItem: Any, newItem: Any): Any? {
        return viewBinders[oldItem::class.java]?.getChangePayload(oldItem, newItem)
    }
}