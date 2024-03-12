package com.example.androidfinalpractice.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidfinalpractice.data.api.PhoneApi
import com.example.androidfinalpractice.data.cache.PhoneCache
import com.example.androidfinalpractice.models.Phone
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhoneViewModel(app: Application) : AndroidViewModel(app) {
    private val api = PhoneApi()
    private val cache = PhoneCache(app)

    val phones: MutableLiveData<List<Phone>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getPhones() {
        showLoading()

        if (cache.hasPhones()) {
            Log.d("OAT", "Using cache")
            val response = cache.getPhones()
            phones.postValue(response)
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                Log.d("OAT", "Calling API")
                val response = api.getPhones()
                phones.postValue(response)
                cache.setPhones(response)
            }
        }
        dismissLoading()
    }

    private fun showLoading() {
        isLoading.postValue(true)
    }

    private fun dismissLoading() {
        isLoading.postValue(false)
    }
}
