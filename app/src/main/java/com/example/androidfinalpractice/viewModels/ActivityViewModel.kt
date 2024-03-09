package com.example.androidfinalpractice.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidfinalpractice.data.api.ActivityApi
import com.example.androidfinalpractice.models.ActivityResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityViewModel: ViewModel() {
    private val api = ActivityApi()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val activity: MutableLiveData<ActivityResponse> = MutableLiveData()

    fun getActivity() {
        showLoading()
        viewModelScope.launch(Dispatchers.IO) {
            val response = api.getActivity()

            activity.postValue(response)
            dismissLoading()
        }
    }

    fun showLoading() {
        isLoading.postValue(true)
    }

    fun dismissLoading() {
        isLoading.postValue(false)
    }
}