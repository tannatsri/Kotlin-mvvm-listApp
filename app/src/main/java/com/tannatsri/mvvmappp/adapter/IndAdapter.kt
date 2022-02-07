package com.tannatsri.mvvmappp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tannatsri.mvvmappp.resources.AdapterItemDiffCallback
import com.tannatsri.mvvmappp.resources.ModelClass
import com.tannatsri.mvvmappp.resources.ViewBinder

class IndAdapter(
    private val viewBinders: Map<ModelClass, ViewBinder>
) : ListAdapter<Any, RecyclerView.ViewHolder>(AdapterItemDiffCallback(viewBinders)) {

    private val viewTypeToBinders = viewBinders.mapKeys { it.value.getViewType() }

    private fun getViewBinder(viewType: Int): ViewBinder {
        return viewTypeToBinders.getValue(viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return viewBinders.getValue(super.getItem(position).javaClass).getViewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewBinder(viewType).createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getViewBinder(getItemViewType(position)).bindViewHolder(getItem(position), holder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNullOrEmpty() || payloads.getOrNull(0) == null) {
            onBindViewHolder(holder, position)
        } else {
            getViewBinder(getItemViewType(position)).bindViewHolderWithPayload(getItem(position), holder, payloads[0])
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        getViewBinder(holder.itemViewType).onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        getViewBinder(holder.itemViewType).onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        getViewBinder(holder.itemViewType).onViewAttachedToWindow(holder)
        super.onViewAttachedToWindow(holder)
    }


}