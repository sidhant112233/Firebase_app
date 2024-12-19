package com.example.firebase_app.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebase_app.R
import com.example.firebase_app.databinding.ActivitySettingBinding
import com.example.firebase_app.helper.AuthHelper.Companion.authHelper

class Setting_Activity : AppCompatActivity() {
    lateinit var binding : ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logout.setOnClickListener {
            authHelper.signout()
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
            finish()
        }

    }
}