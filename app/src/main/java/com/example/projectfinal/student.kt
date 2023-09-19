package com.example.projectfinal

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*


class student : AppCompatActivity() {
    private  var db= Firebase.firestore
    private lateinit var image:ImageView

    private  lateinit var brupload:Button
    private lateinit var uri: Uri
    private var storage=Firebase.storage
    @SuppressLint("MissingInflatedId")
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
        image=findViewById<ImageView>(R.id.imageView)
        val docRef=db.collection("user").document(uid)
        docRef.get().addOnSuccessListener {document->
            if(document!=null)
            {
                val username=document.data!!["name"].toString()
                val imageurl=document.data!!["url"].toString()
                user.text=username
                Picasso.get().load(imageurl).into(image);
            }

        }

        //image upload
        storage= FirebaseStorage.getInstance()
        image=findViewById(R.id.imageView)
       val brbutton=findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.upload)
//        brupload=findViewById(R.id.upload)

        val galryimage=registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                image.setImageURI(it)
                if (it != null) {
                    uri=it

                    upload(uri)
                }
            }
        )


//        brbutton.setOnClickListener{
//            galryimage.launch("image/*")
//            upload()
//        }

        brbutton.setOnClickListener {
            // Launch the image selection process
            galryimage.launch("image/*")
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

    private fun upload(uri: Uri){
        storage.getReference("images").child(System.currentTimeMillis().toString())
            .putFile(uri)
            .addOnSuccessListener { task ->
                task.metadata!!.reference!!.downloadUrl
                    .addOnSuccessListener {
                        val userId=FirebaseAuth.getInstance().currentUser!!.uid.toString()

                        val map= mapOf(
                            "url" to it.toString()
                        )
                        val database=FirebaseDatabase.getInstance().getReference("userimages")
                        val db=Firebase.firestore
                        db.collection("user").document(userId).update(map)
                        database.child(userId).setValue(map)
                            .addOnSuccessListener {
                                Toast.makeText(this,"successful", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener{error ->
                                Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT).show()
                            }
                    }
            }
    }
}

