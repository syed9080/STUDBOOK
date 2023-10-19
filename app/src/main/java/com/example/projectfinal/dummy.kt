package com.example.projectfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class dummy : AppCompatActivity() {
    private var db = Firebase.firestore
    private var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)

        var user = findViewById<TextView>(R.id.name)

        val uid = auth.currentUser?.uid.toString()

        Toast.makeText(this,uid,Toast.LENGTH_SHORT).show()




        val docRef=db.collection("user").document(uid)
        docRef.get().addOnSuccessListener {document->
            if(document!=null)
            {
                val username=document.data!!["name"].toString()
                user.text=username
            }

        }




    }
}