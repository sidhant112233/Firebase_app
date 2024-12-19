package com.example.firebase_app.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_app.R
import com.example.firebase_app.helper.AuthHelper
import com.example.firebase_app.helper.AuthHelper.Companion.authHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val intent: Intent
            if (authHelper.auth.currentUser != null) {
                intent = Intent(this, Home_Activity::class.java)
            } else {
                intent = Intent(this, Login_Activity::class.java)
            }
            startActivity(intent)
            finish()

        }, 3000)
    }
}
