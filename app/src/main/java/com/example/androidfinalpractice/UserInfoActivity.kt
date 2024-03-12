package com.example.androidfinalpractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidfinalpractice.data.cache.UserCache
import com.example.androidfinalpractice.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private val view: ActivityUserInfoBinding by lazy { ActivityUserInfoBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        val cache = UserCache(this)
        val userInfo = cache.getUserInfo()

        if (userInfo != null) {
            view.tvUserName.text = userInfo.username
            view.tvPassword.text = userInfo.password
        } else {
            Toast.makeText(this, "User is not log in", Toast.LENGTH_SHORT).show()
        }
    }
}