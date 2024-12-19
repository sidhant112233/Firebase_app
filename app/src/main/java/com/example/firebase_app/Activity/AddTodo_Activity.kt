package com.example.firebase_app.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase_app.databinding.ActivityAddTodoBinding
import com.example.firebase_app.helper.FireStorehelper.Companion.fireStorehelper

class AddTodo_Activity : AppCompatActivity() {
    lateinit var binding: ActivityAddTodoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.crdAdd.setOnClickListener {
            val title = binding.titleInput.text.toString()
            val detail = binding.detailInput.text.toString()

            if (title.isNotEmpty() && detail.isNotEmpty())
            {
                fireStorehelper.addtodo(title,detail)
                finish()
            }
            else{
                Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT).show()
            }

        }

    }
}