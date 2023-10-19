package com.example.projectfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectfinal.databinding.ActivitySignInBinding

import com.example.projectfinal.databinding.ActivityStaffSignInActiviyBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class  StaffSignInActiviy : AppCompatActivity() {

    private lateinit var binding: ActivityStaffSignInActiviyBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStaffSignInActiviyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() ) {
                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        val uid= firebaseAuth.uid.toString()
                        var Role="none"
                        var docRef :DocumentReference


                        docRef = db.collection("staff").document(uid)
                        Toast.makeText(this, uid, Toast.LENGTH_SHORT).show()

                        docRef.get().addOnSuccessListener { document ->
                            if (document != null) {
                                Role = document.data!!["Role"].toString()
                            }
                            Toast.makeText(this, Role, Toast.LENGTH_SHORT).show()

                            Toast.makeText(this, uid, Toast.LENGTH_SHORT).show()
                            if (it.isSuccessful && Role=="staff") {
                                val intent = Intent(this, StaffView::class.java)
                                intent.putExtra(getString(R.string.key_email), email)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, "this place", Toast.LENGTH_SHORT)
                                    .show()

                            }

                        }

                    }
                }else {
                    Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT)
                        .show()

                }
            }
        }
    }


