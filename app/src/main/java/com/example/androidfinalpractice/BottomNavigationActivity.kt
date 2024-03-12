package com.example.androidfinalpractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.androidfinalpractice.databinding.ActivityBottomNavigationBinding
import com.example.androidfinalpractice.fragments.FragmentA
import com.example.androidfinalpractice.fragments.FragmentB
import com.example.androidfinalpractice.fragments.FragmentC

class BottomNavigationActivity : AppCompatActivity() {
    private val view: ActivityBottomNavigationBinding by lazy {
        ActivityBottomNavigationBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.bnvExample.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> changeFragment(FragmentA())
                R.id.item_profile -> changeFragment(FragmentB())
                R.id.item_setting -> changeFragment(FragmentC())
                else -> false
            }
        }
    }

    private fun changeFragment(fragment: Fragment): Boolean {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcExample, fragment)
            .addToBackStack(fragment::class.java.name)
            .commit()

        return true
    }
}