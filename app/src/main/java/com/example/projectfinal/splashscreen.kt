package com.example.projectfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen2)
        Handler().postDelayed({
            val intent = Intent(this@splashscreen,chooseRole::class.java)
            startActivity(intent)
            finish()

        },3000)
    }
    }
