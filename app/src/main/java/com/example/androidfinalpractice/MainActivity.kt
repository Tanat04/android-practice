package com.example.androidfinalpractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfinalpractice.databinding.ActivityMainBinding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    private val view: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnFragment1.setOnClickListener {
            val intent = Intent(this, Fragment1Activity::class.java)
            startActivity(intent)
        }

        view.btnFragment2.setOnClickListener {
            val intent = Intent(this, Fragment2Activity::class.java)
            startActivity(intent)
        }
//
//        view.btnApiCall.setOnClickListener {
//            val intent = Intent(this, ApiCallActivity::class.java)
//            startActivity(intent)
//        }

        view.btnApiCall.setOnClickListener {
            val intent = Intent(this, ApiCallActivity::class.java)
            startActivity(intent)
        }

        view.btnUniversity.setOnClickListener {
            val intent = Intent(this, UniversityListActivity::class.java)
            startActivity(intent)
        }

        view.btnNotification.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        view.btnGoogleMap.setOnClickListener {
            val intent = Intent(this, GoogleMapActivity::class.java)
            startActivity(intent)
        }

        view.btnFirebase.setOnClickListener {
            val intent = Intent(this, FirebaseActivity::class.java)
            startActivity(intent)
        }

        view.btnGPS.setOnClickListener {
            val intent = Intent(this, GPSActivity::class.java)
            startActivity(intent)
        }

        view.btnCamera.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }
    }
}