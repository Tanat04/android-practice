package com.example.androidfinalpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfinalpractice.data.cache.UserCache
import com.example.androidfinalpractice.databinding.ActivityLoginBinding
import com.example.androidfinalpractice.models.UserInfo

class LoginActivity : AppCompatActivity() {
    private val view: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        val cache = UserCache(this)

        if (cache.isLogin()) {
            val intent = Intent(this, UserInfoActivity::class.java)
            startActivity(intent)
        }

        view.btnLogin.setOnClickListener {
            val userName = view.tvUserName.text.toString()
            val password = view.tvPassword.text.toString()

            if (userName == "admin" && password == "admin") {
                cache.setUserInfo(
                    UserInfo(
                        username = userName,
                        password = password
                    )
                )
                val intent = Intent(this, UserInfoActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }
}