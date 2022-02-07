package com.tannatsri.mvvmappp

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tannatsri.mvvmappp.adapter.IndAdapter
import com.tannatsri.mvvmappp.adapter.SchoolListAdapter2
import com.tannatsri.mvvmappp.data.SchoolModel
import com.tannatsri.mvvmappp.resources.ModelClass
import com.tannatsri.mvvmappp.resources.ViewBinder
import com.tannatsri.mvvmappp.viewHolder.PayoutCardViewHolder
import com.tannatsri.mvvmappp.viewHolder.PayoutStatusViewHolder


import com.tannatsri.mvvmappp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.order_data.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var dialog : ProgressDialog?= null
    private var adapter: IndAdapter? = null
    private var list = mutableListOf<MainActivityViewModel.PayoutAdapterView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_data)
        dialog = ProgressDialog(this@MainActivity)
        dialog?.setTitle("Loading..")
        dialog?.show()
        initRecyclerView()
        initViewModel()
    }


    private fun initRecyclerView() {
        payoutDetailRecyclerView?.apply {
            this.layoutManager =  LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            val binderMap = mutableMapOf<ModelClass, ViewBinder>()


            val payoutStatusViewBinder = PayoutStatusViewHolder.PayoutStatusViewBinder()
            val payoutCardViewBinder = PayoutCardViewHolder.PayoutCardViewBinder()

            binderMap[payoutCardViewBinder.model] = payoutCardViewBinder as ViewBinder
            binderMap[payoutStatusViewBinder.model] = payoutStatusViewBinder as ViewBinder


            this@MainActivity.adapter = IndAdapter(binderMap)
            adapter = this@MainActivity.adapter
        }

    }

    private fun initViewModel() {
        val viewModel: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, {
            dialog?.hide()
            if (it != null) {
//                Log.d("tanishq", it.toString())
                list.add(MainActivityViewModel.PayoutAdapterView.PayoutStatus(it.order_status))
                list.add(MainActivityViewModel.PayoutAdapterView.PayoutCard(it.order_details))
                val finalList = list.toList().toMutableList()
//                _techStarHoldingLiveData.value = RewardsDashboardDetailState.HoldingsData(finalList)
//                Log.d("tanishq", finalList.toString())
                adapter?.submitList(finalList as List<Any>?)

            }
            else
             Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
        })

        viewModel.makeApiCall()

    }



}