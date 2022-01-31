package com.tannatsri.mvvmappp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tannatsri.mvvmappp.adapter.SchoolListAdapter
import com.tannatsri.mvvmappp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dialog : ProgressDialog?= null
    lateinit var recyclerAdapter: SchoolListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialog = ProgressDialog(this@MainActivity)
        dialog?.setTitle("Loading..")
        dialog?.show()
        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView() {
        schoolListRecyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = SchoolListAdapter()

        schoolListRecyclerView.adapter = recyclerAdapter

    }

    private fun initViewModel() {
        val viewModel: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, {
            dialog?.hide()
            if (it != null) {
                recyclerAdapter.setSchoolList(it.school)
                recyclerAdapter.notifyDataSetChanged()
            }else
             Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
        })

        viewModel.makeApiCall()

    }
}