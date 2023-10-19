package com.example.projectfinal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class forgetpassword : AppCompatActivity() {

    private  lateinit var  remail:EditText
    private lateinit var reset:Button
    private  lateinit var auth:FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpassword)
        remail=findViewById(R.id.email)
        reset=findViewById(R.id.submit)
        auth=FirebaseAuth.getInstance()
        reset.setOnClickListener{
            val semail=remail.text.toString()
            auth.sendPasswordResetEmail(semail)
                .addOnSuccessListener {
                    Toast.makeText(this,"Please check your email",Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener{
                    Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
                }

        }


    }
}
