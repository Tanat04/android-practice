package com.example.androidfinalpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfinalpractice.adapters.PhoneListAdapter
import com.example.androidfinalpractice.data.api.UniversityApi
import com.example.androidfinalpractice.databinding.ActivityTbhactivityBinding
import com.example.androidfinalpractice.models.Phone
import com.example.androidfinalpractice.viewModels.PhoneViewModel
import kotlinx.coroutines.launch

class TBHActivity : AppCompatActivity() {
    private val view: ActivityTbhactivityBinding by lazy {
        ActivityTbhactivityBinding.inflate(
            layoutInflater
        )
    }
    private val viewModel: PhoneViewModel by viewModels()
    private val phones: MutableList<Phone> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        viewModel.getPhones()

        view.rvPhones.adapter = PhoneListAdapter(phones)
        view.rvPhones.layoutManager = LinearLayoutManager(this)
        view.TBHSwipeLayout.setOnRefreshListener {
            viewModel.getPhones()
        }

        viewModel.phones.observe(this) { phoneList ->
            phones.clear()
            phones.addAll(phoneList)
            view.rvPhones.adapter?.notifyDataSetChanged()
        }

        viewModel.isLoading.observe(this) { isLoading ->
            view.TBHSwipeLayout.isRefreshing = isLoading
        }
    }
}