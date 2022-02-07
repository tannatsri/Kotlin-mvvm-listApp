package com.tannatsri.mvvmappp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.tannatsri.mvvmappp.MainActivity
import com.tannatsri.mvvmappp.R
import com.tannatsri.mvvmappp.data.SchoolModel
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

    override fun submitList(list: MutableList<SchoolModel>?) {
        super.submitList(list?.toMutableList())
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SchoolListAdapter2.ViewHolder {

        return when(viewType) {
            R.layout.vertical_layout -> SchoolListAdapter2.ViewHolder.NonBoldLayout(
                VerticalLayoutBinding.inflate(
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

        if(position % 2 == 0) return R.layout.school_list_layout
        else return R.layout.school_list_layout

    }



    sealed class ViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {



        class NonBoldLayout(
            private val binding: VerticalLayoutBinding
        ): ViewHolder(binding) {
            lateinit var delButton: ImageButton
            lateinit var schoolCountry2: TextView
            lateinit var schoolName2: TextView

            init {
                delButton = binding.deleteButton
                schoolCountry2 = binding.schoolCountry2
                schoolName2 = binding.schoolName2
                delButton.setOnClickListener {


//                    super.deleteFromList(adapterPosition)


                }
            }




            fun bind(data: SchoolModel) {
                binding.schoolName2.text = data.name?.slice(0..5)
                binding.schoolCountry2.text = data.alpha_two_code

            }


        }
        class BoldLayout(private val binding: VerticalLayoutBinding): ViewHolder(binding) {
            var delButton: ImageButton? = null
            fun bind(data: SchoolModel) {
                binding.schoolName2.text = data.name?.slice(0..5)
                binding.schoolCountry2.text = data.alpha_two_code


            }

        }


    }



}