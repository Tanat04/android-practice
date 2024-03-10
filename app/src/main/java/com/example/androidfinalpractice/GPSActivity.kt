package com.example.androidfinalpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.androidfinalpractice.databinding.ActivityGpsactivityBinding
import com.example.androidfinalpractice.utils.PermissionHandler
import com.example.androidfinalpractice.viewModels.GPSViewModel

class GPSActivity : AppCompatActivity() {

    private val view: ActivityGpsactivityBinding by lazy {
        ActivityGpsactivityBinding.inflate(
            layoutInflater
        )
    }
    private val viewModel: GPSViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        PermissionHandler.requestPermissionIfRequired(this, PermissionHandler.GPS)

        view.btnGetLocation.setOnClickListener {
            viewModel.getCurrentLocation()
        }

        viewModel.userLocation.observe(this) {
            view.tvUserLocation.text = "Your location: ${it.latitude}, ${it.longitude}"
        }

        viewModel.error.observe(this) {
            AlertDialog.Builder(this)
                .setTitle("Something went wrong")
                .setMessage(it.message).setPositiveButton("Ok") { dialog, _ -> dialog.cancel() }

        }
    }
}