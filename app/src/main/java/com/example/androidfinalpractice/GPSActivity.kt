package com.example.androidfinalpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfinalpractice.databinding.ActivityGpsactivityBinding

class GPSActivity : AppCompatActivity() {

    private val view: ActivityGpsactivityBinding by lazy { ActivityGpsactivityBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
    }
}