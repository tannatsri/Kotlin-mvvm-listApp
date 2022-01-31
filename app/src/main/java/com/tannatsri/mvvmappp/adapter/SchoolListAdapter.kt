package com.tannatsri.mvvmappp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.tannatsri.mvvmappp.R
import com.tannatsri.mvvmappp.data.SchoolModel
import com.tannatsri.mvvmappp.databinding.SchoolListLayoutBinding
import com.tannatsri.mvvmappp.databinding.VerticalLayoutBinding
import kotlinx.android.synthetic.main.school_list_layout.view.*

class SchoolListAdapter: RecyclerView.Adapter<SchoolListAdapter.ViewHolder>() {


    private var schoolList: List<SchoolModel>? = null


    fun setSchoolList(schoolList: List<SchoolModel>? ) {
        this.schoolList = schoolList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SchoolListAdapter.ViewHolder {

        return when(viewType) {
            R.layout.vertical_layout -> ViewHolder.NonBoldLayout(
                SchoolListLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.school_list_layout -> ViewHolder.BoldLayout(
                VerticalLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: SchoolListAdapter.ViewHolder, position: Int) {

        when(holder) {
            is ViewHolder.BoldLayout -> holder.bind(schoolList?.get(position)!!)
            is ViewHolder.NonBoldLayout -> holder.bind(schoolList?.get(position)!!)
        }

    }
    override fun getItemViewType(position: Int): Int {

        if(position % 2 == 0) return R.layout.vertical_layout
        else return R.layout.school_list_layout

    }

    override fun getItemCount(): Int {
        if(schoolList == null) return 0
        return schoolList!!.size
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