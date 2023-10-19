package com.example.projectfinal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class additional_details : AppCompatActivity() {

    private lateinit var name_organization :EditText
    private lateinit var address_organization :EditText
    private lateinit var sports :EditText
    private lateinit var exam :EditText
    private lateinit var score :EditText
    private lateinit var title :EditText
    private lateinit var team_member :EditText
    private lateinit var guide :EditText
    private lateinit var cgpa :EditText
    private lateinit var rank :EditText
    private lateinit var s1 :Button
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var uid:String
    var db= Firebase.firestore

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additional_details)

        val message = intent.getStringExtra("Id")?.toString()

        uid="none"
        if(message!=null)
        {
            Toast.makeText(this,"wrong", Toast.LENGTH_SHORT).show()
            uid=message
        }
        else {
            Toast.makeText(this,"correct executer", Toast.LENGTH_SHORT).show()
            uid = FirebaseAuth.getInstance().uid.toString()
        }
        val docRef=db.collection("user").document(uid)
        docRef.get().addOnSuccessListener {document->
            if(document!=null)
            {


                val additionalDetails= document!!["additional_details"]
                if(additionalDetails!=null) {
                    additionalDetails  as Map<*, *>
                    val tittle=additionalDetails["title"] as String
                    title.setText(tittle)
                    val teammember = additionalDetails["teammember"] as String
                    team_member.setText(teammember)
                    val guidee = additionalDetails["guide"] as String
                    guide.setText(guidee)
                    val cgpaa = additionalDetails["cgpa"] as String
                    cgpa.setText(cgpaa)
                    val rankk =additionalDetails["rank"] as String
                    rank.setText(rankk)
                    val  organization=additionalDetails["nameorganization"] as String
                    name_organization.setText(organization)
                    val address =additionalDetails["addressorganization"] as String
                    address_organization.setText(address)
                    val sportss =additionalDetails["sports"] as String
                    sports.setText(sportss)
                    val examm =additionalDetails["exam"] as String
                    exam.setText(examm)
                    val scoree =additionalDetails["score"] as String
                    score.setText(scoree)

                }

            }

        }



















        title = findViewById(R.id.title)
        team_member = findViewById(R.id.team)
        guide = findViewById(R.id.guide)
        cgpa = findViewById(R.id.cgpa)
        rank = findViewById(R.id.rank)
        name_organization = findViewById(R.id.organization)
        address_organization = findViewById(R.id.address)
        sports = findViewById(R.id.sports)
        exam = findViewById(R.id.exam)
        score = findViewById(R.id.score)
        s1 = findViewById(R.id.s1)

        firebaseAuth = FirebaseAuth.getInstance()
        s1.setOnClickListener{



            val titlee = title.text.toString()
            val teammember = team_member.text.toString()
            val guidee = guide.text.toString()
            val cgpaa = cgpa.text.toString()
            val rankk = rank.text.toString()
            val nameorganization = name_organization.text.toString()
            val addressorganization = address_organization.text.toString()
            val sportss = sports.text.toString()
            val examm = exam.text.toString()
            val scoree = score.text.toString()

            val basic_details = mapOf(
                "title" to titlee,
                "teammember" to teammember,
                "guide" to guidee,
                "cgpa" to cgpaa,
                "rank" to rankk,
                "nameorganization" to nameorganization,
                "addressorganization" to addressorganization,
                "sports" to sportss,
                "exam" to examm,
                "score" to scoree,
            )

            val additional_details = mapOf(
                "additional_details" to basic_details

            )

            db.collection("user").document(uid).update(additional_details)
        }
    }
}