package com.example.projectfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.projectfinal.R
import com.example.projectfinal.academic_details
import com.example.projectfinal.additional_details
import com.example.projectfinal.educational_details
import com.example.projectfinal.student_details
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class student : AppCompatActivity() {
    private  var db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        var studDetails = findViewById<ImageButton>(R.id.imageButton3)
        var eduDetails = findViewById<ImageButton>(R.id.imageButton4)
        var acadDetails = findViewById<ImageButton>(R.id.imageButton)
        var addDetails = findViewById<ImageButton>(R.id.imageButton2)
        val logout = findViewById<Button>(R.id.logout)
        var user=findViewById<TextView>(R.id.User)

        val uid= FirebaseAuth.getInstance().uid.toString()
        val image=findViewById<ImageView>(R.id.imageView2)
        val docRef=db.collection("user").document(uid)
        docRef.get().addOnSuccessListener {document->
            if(document!=null)
            {
                val username=document.data!!["name"].toString()
//                val rollno=document.data!!["rollno"].toString()
                val imageurl=document.data!!["url"].toString()
                user.text=username
//                roll.text=rollno
                Picasso.get().load(imageurl).into(image);
            }

        }
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

        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}

