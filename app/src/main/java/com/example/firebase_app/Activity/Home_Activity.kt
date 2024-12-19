package com.example.firebase_app.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebase_app.R
import com.example.firebase_app.databinding.ActivityHomeBinding
import com.example.firebase_app.helper.AuthHelper.Companion.authHelper

class Home_Activity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgprofile.setOnClickListener {

            val intent = Intent(this,Setting_Activity::class.java)
            startActivity(intent)

        }

        binding.addtodo.setOnClickListener {
            val intent = Intent(this,AddTodo_Activity::class.java)
            startActivity(intent)
        }

        binding.userId.text = authHelper.auth.currentUser?.email

    }
}