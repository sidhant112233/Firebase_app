package com.example.firebase_app.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_app.databinding.ActivitySignupBinding
import com.example.firebase_app.helper.AuthHelper.Companion.authHelper

lateinit var binding: ActivitySignupBinding

class Signup_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsinup.setOnClickListener {

            var email = binding.email.text.toString()
            var password = binding.password.text.toString()
            var cpassword = binding.cpassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && cpassword.isNotEmpty()) {
                if (password != cpassword) {
                    Toast.makeText(
                        this,
                        "Reseted password is not match to confirm password",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    authHelper.signup(email, password)
                    Toast.makeText(this,"Sign up successfully", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }else{
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }

        }

        binding.imgback.setOnClickListener {
            finish()
        }


    }
}

