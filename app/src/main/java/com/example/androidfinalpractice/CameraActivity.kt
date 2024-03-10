package com.example.androidfinalpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfinalpractice.databinding.ActivityCameraBinding
import com.example.androidfinalpractice.databinding.ActivityGpsactivityBinding

class CameraActivity : AppCompatActivity() {
    private val view: ActivityCameraBinding by lazy { ActivityCameraBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
    }
}