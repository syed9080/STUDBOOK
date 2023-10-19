package com.example.projectfinal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class StaffView : AppCompatActivity() {
    private  var db= Firebase.firestore
    private lateinit var recyclerView:RecyclerView
    private lateinit var studentAdapter: StudentAdapter
    private val studentList = ArrayList<student_data>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_view)
        val message = intent.getStringExtra("email_key").toString()

        val logout = findViewById<Button>(R.id.s1)
        var firestoredb=FirebaseFirestore.getInstance()
        var firebaseauth=FirebaseAuth.getInstance()
        val uid=firebaseauth.currentUser?.uid.toString()


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        studentAdapter = StudentAdapter(this,studentList,message)
        recyclerView.adapter = studentAdapter

        // Fetch data from Firebase Firestore
        fetchStudentDataFromFirestore()
        // get from firebase











        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, StaffSignInActiviy::class.java)
            startActivity(intent)
        }
    }

    private fun fetchStudentDataFromFirestore() {
        val db = FirebaseFirestore.getInstance()
        val studentsCollection = db.collection("user")

        studentsCollection.get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents) {
                    val rollno = document.getString("rollno")
                    val name=document.getString("name")
                    val Id=document.getString("Id")
                    if (rollno != null) {
                        val student = student_data(rollno as String,name as String,Id as String)
                        studentList.add(student)
                    }
                }
                studentAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                // Handle the error
            }
    }
}