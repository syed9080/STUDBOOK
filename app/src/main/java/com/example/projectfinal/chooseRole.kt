package com.example.projectfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class chooseRole : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_role)

        var studentButton = findViewById<ImageButton>(R.id.imageButton2)
        var staffButton = findViewById<ImageButton>(R.id.imageButton3)
        studentButton.setOnClickListener{


            val intent = Intent(this@chooseRole,SignInActivity::class.java)
            startActivity(intent)
        }
        staffButton.setOnClickListener{
            val intent = Intent(this@chooseRole,SignInActivity::class.java)
            startActivity(intent)
        }
    }


    }
