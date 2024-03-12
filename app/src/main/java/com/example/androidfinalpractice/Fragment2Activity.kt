package com.example.androidfinalpractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfinalpractice.databinding.ActivityFragment2Binding
import com.example.androidfinalpractice.fragments.FragmentA
import com.example.androidfinalpractice.fragments.FragmentB
import com.example.androidfinalpractice.fragments.FragmentC

class Fragment2Activity : AppCompatActivity() {
    private val view: ActivityFragment2Binding by lazy { ActivityFragment2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnFragmentA.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fcFragment2, FragmentA())
                .addToBackStack(FragmentA::class.java.name)
                .commit()
        }

        view.btnFragmentB.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fcFragment2, FragmentB())
                .addToBackStack(FragmentB::class.java.name)
                .commit()
        }

        view.btnFragmentC.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fcFragment2, FragmentC())
                .addToBackStack(FragmentC::class.java.name)
                .commit()
        }
    }
}