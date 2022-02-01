package com.tannatsri.mvvmappp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.tannatsri.mvvmappp.R
import com.tannatsri.mvvmappp.data.SchoolModel
import com.tannatsri.mvvmappp.databinding.SchoolListLayoutBinding
import com.tannatsri.mvvmappp.databinding.VerticalLayoutBinding



val differCallback = object: DiffUtil.ItemCallback<SchoolModel>() {
    override fun areItemsTheSame(oldItem: SchoolModel, newItem: SchoolModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: SchoolModel, newItem: SchoolModel): Boolean {
        return oldItem.name == newItem.name
    }
}


class SchoolListAdapter2: ListAdapter<SchoolModel, SchoolListAdapter2.ViewHolder>(differCallback) {

//    private val differ  = AsyncListDiffer(this, differCallback)

//    override fun submitList(list: MutableList<SchoolModel>?) {
//        Log.d("tanishq1", list.toString())
//        super.submitList(list?.let { ArrayList(it) })
//    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SchoolListAdapter2.ViewHolder {

        return when(viewType) {
            R.layout.vertical_layout -> SchoolListAdapter2.ViewHolder.NonBoldLayout(
                SchoolListLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.school_list_layout -> SchoolListAdapter2.ViewHolder.BoldLayout(
                VerticalLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Log.d("tanishq", differ.currentList.toString())

        val school = getItem(position)
        when(holder) {
            is SchoolListAdapter2.ViewHolder.BoldLayout -> holder.bind(school)
            is SchoolListAdapter2.ViewHolder.NonBoldLayout -> holder.bind(school)
        }

    }
    override fun getItemViewType(position: Int): Int {

        if(position % 2 == 0) return R.layout.vertical_layout
        else return R.layout.school_list_layout

    }



    sealed class ViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

        class NonBoldLayout(private val binding: SchoolListLayoutBinding): ViewHolder(binding) {
            fun bind(data: SchoolModel) {
                binding.schoolName.text = data.alpha_two_code
                binding.schoolCountry.text = "Country: " + data.country
                binding.schoolAlpha.text = data.name
            }
        }
        class BoldLayout(private val binding: VerticalLayoutBinding): ViewHolder(binding) {
            fun bind(data: SchoolModel) {
                binding.schoolName2.text = data.alpha_two_code
                binding.schoolCountry2.text = "Country: " + data.country
                binding.schoolAlpha2.text = data.name
            }
        }


    }
}