package com.example.firebase_app.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_app.databinding.ActivityLoginBinding
import com.example.firebase_app.helper.AuthHelper.Companion.authHelper


class Login_Activity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.crdlogin.setOnClickListener {

            val email = binding.user.text.toString()
            val password = binding.password.text.toString()


            var msg = authHelper.sigin(email, password)

            if (msg == "Success") {
                val intent = Intent(this@Login_Activity, Home_Activity::class.java)
                startActivity(intent)
                finish()
            } else {
                Log.d("Tag", "Failde")
            }


        }



        binding.txtsignup.setOnClickListener {
            val intent = Intent(this, Signup_Activity::class.java)
            startActivity(intent)
        }
    }
}


