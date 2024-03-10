package com.example.androidfinalpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import com.example.androidfinalpractice.databinding.ActivityGoogleMapBinding
import com.example.androidfinalpractice.viewModels.GPSViewModel
import com.google.android.gms.maps.GoogleMap

class GoogleMapActivity : AppCompatActivity() {

    private val view: ActivityGoogleMapBinding by lazy { ActivityGoogleMapBinding.inflate((layoutInflater)) }
    private val viewModel: GPSViewModel by viewModels()

    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.mvGoogleMap.onCreate(savedInstanceState)

        view.mvGoogleMap.getMapAsync {
            map = it
        }
    }

    override fun onStart() {
        super.onStart()
        view.mvGoogleMap.onStart()
    }

    override fun onResume() {
        super.onResume()
        view.mvGoogleMap.onResume()
    }

    override fun onPause() {
        super.onPause()
        view.mvGoogleMap.onPause()
    }

    override fun onStop() {
        super.onStop()
        view.mvGoogleMap.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        view.mvGoogleMap.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        view.mvGoogleMap.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        view.mvGoogleMap.onSaveInstanceState(outState)
    }
}