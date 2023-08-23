package com.example.projectfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.projectfinal.R
import com.example.projectfinal.academic_details
import com.example.projectfinal.additional_details
import com.example.projectfinal.educational_details
import com.example.projectfinal.student_details

class student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        var studDetails = findViewById<ImageButton>(R.id.imageButton3)
        var eduDetails = findViewById<ImageButton>(R.id.imageButton4)
        var acadDetails = findViewById<ImageButton>(R.id.imageButton)
        var addDetails = findViewById<ImageButton>(R.id.imageButton2)

        studDetails.setOnClickListener{
            val intent = Intent(this@student, student_details::class.java)
            startActivity(intent)
        }
        eduDetails.setOnClickListener{
            val intent = Intent(this@student, educational_details::class.java)
            startActivity(intent)
        }
        acadDetails.setOnClickListener {
            val intent = Intent(this@student, academic_details::class.java)
            startActivity(intent)
        }
        addDetails.setOnClickListener {
            val intent = Intent(this@student, additional_details::class.java)
            startActivity(intent)
        }
    }
}

