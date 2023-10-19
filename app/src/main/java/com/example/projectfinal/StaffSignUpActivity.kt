package com.example.projectfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



import com.example.projectfinal.databinding.ActivityStaffSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class StaffSignUpActivity : AppCompatActivity() {


    private lateinit var binding: ActivityStaffSignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    var db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStaffSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, StaffSignInActiviy::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val rollno = binding.rollno.text.toString()
            val user=binding.username.text.toString()

            val basic = mapOf(
                "name" to user,
                "StaffID" to rollno,
                "Role" to  "staff"
            )


            if (email.isNotEmpty() && pass.isNotEmpty()) {


                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val uid= firebaseAuth.currentUser?.uid.toString()
                        val intent = Intent(this, StaffSignInActiviy::class.java)
                        db.collection("staff").document(uid).set(basic)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}