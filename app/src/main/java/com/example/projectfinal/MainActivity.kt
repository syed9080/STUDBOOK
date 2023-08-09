package com.example.projectfinal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.projectfinal.R
import com.example.projectfinal.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private  var db=Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logout = findViewById<Button>(R.id.logout)
        val button= findViewById<Button>(R.id.button)

        val user=findViewById<TextView>(R.id.username)
        val roll=findViewById<TextView>(R.id.rollno)


//        button.setOnClickListener{
//                val sname=user.text.toString()
//                val sroll=user.text.toString()
//            val basic= hashMapOf(
//                "name" to sname,
//                "rollno" to sroll
//            )
//            val uid=FirebaseAuth.getInstance().uid.toString()
//             db.collection("user").document(uid).set(basic)
//        }
        val uid=FirebaseAuth.getInstance().uid.toString()
        val docRef=db.collection("user").document(uid)
        docRef.get().addOnSuccessListener {document->
            if(document!=null)
            {
                val username=document.data!!["name"].toString()
                val rollno=document.data!!["rollno"].toString()

                user.text=username
                roll.text=rollno
            }

        }




        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}

