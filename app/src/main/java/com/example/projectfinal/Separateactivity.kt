package com.example.projectfinal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Calendar

class Separateactivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
//    private lateinit var dateEditText: TextView
    private lateinit var fname: TextView
    private lateinit var rollnum: TextView
    private lateinit var Degree: TextView
    private lateinit var special: TextView
    private lateinit var pname: TextView
    private lateinit var address: TextView
    private lateinit var pemail: TextView
    private lateinit var pphone: TextView
    private lateinit var dob: TextView
    private lateinit var from: TextView
    private lateinit var to: TextView
    private lateinit var religion: TextView
    private lateinit var blood: TextView
    private lateinit var comm: TextView
    private lateinit var doj: TextView

    //education details
    private lateinit var smed: TextView
    private lateinit var syear: TextView
    private lateinit var sboard: TextView
    private lateinit var sins: TextView
    private lateinit var smarks: TextView
    private lateinit var hmed: TextView
    private lateinit var hyear: TextView
    private lateinit var hboard: TextView
    private lateinit var hins: TextView
    private lateinit var hmarks: TextView
    private lateinit var bmedi: TextView
    private lateinit var byear: TextView
    private lateinit var bboard: TextView
    private lateinit var bins: TextView
    private lateinit var bmarks: TextView

    //academic details

    private lateinit var tutor1: TextView
    private lateinit var arrear1: TextView
    private lateinit var redo1: TextView
    private lateinit var cgpa1: TextView
    private lateinit var res1: TextView
    private lateinit var res2: TextView
    private lateinit var tutor2: TextView
    private lateinit var arrear2: TextView
    private lateinit var redo2: TextView
    private lateinit var cgpa2: TextView
    private lateinit var res3: TextView
    private lateinit var tutor3: TextView
    private lateinit var arrear3: TextView
    private lateinit var redo3: TextView
    private lateinit var cgpa3: TextView
    private lateinit var res4: TextView
    private lateinit var tutor4: TextView
    private lateinit var arrear4: TextView
    private lateinit var redo4: TextView
    private lateinit var cgpa4: TextView


    private val calendar = Calendar.getInstance()

    private val joincalendar = Calendar.getInstance()

    //    private lateinit var firebaseAuth: FirebaseAuth
    var db = Firebase.firestore

    //    private  lateinit var Submit: Buttons
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_separateactivity)

        ///////////academic details
        tutor1 = findViewById(R.id.tutor1)
        cgpa1=findViewById(R.id.cgpa1)
        redo1=findViewById(R.id.redo1)
        arrear1=findViewById(R.id.arrear1)
        res1=findViewById(R.id.res1)

        tutor2 = findViewById(R.id.tutor2)
        cgpa2=findViewById(R.id.cgpa2)
        redo2=findViewById(R.id.redo2)
        arrear2=findViewById(R.id.arrear2)
        res2=findViewById(R.id.res2)

        tutor3 = findViewById(R.id.tutor3)
        cgpa3=findViewById(R.id.cgpa3)
        redo3=findViewById(R.id.redo3)
        arrear3=findViewById(R.id.arrear3)
        res3=findViewById(R.id.res3)

        tutor4 = findViewById(R.id.tutor4)
        cgpa4=findViewById(R.id.cgpa4)
        redo4=findViewById(R.id.redo4)
        arrear4=findViewById(R.id.arrear4)
        res4=findViewById(R.id.res4)


        // Retrieve data passed from the RecyclerView adapter
        val rollno = intent.getStringExtra("rollno")
        val name = intent.getStringExtra("name")
        val id = intent.getStringExtra("Id").toString()

        // data from firebase for display

        val docRef = db.collection("user").document(id)
        docRef.get().addOnSuccessListener { document ->
            if (document != null) {
                val basicDetails = document!!["Basic_Details"]
                if (basicDetails != null) {
                    Toast.makeText(this, "shelkdfj", Toast.LENGTH_SHORT).show()
                    basicDetails as Map<*, *>
                    val name = basicDetails["Name"] as String
                    fname = findViewById(R.id.fname)
                    fname.text = name.toString()
                    val addresss = basicDetails["Address"] as String
                    address = findViewById(R.id.address)
                    address.text = addresss.toString()
                    val roll = basicDetails["Roll No"] as String
                    rollnum = findViewById(R.id.rollno)
                    rollnum.text = roll.toString()
                    val degree = basicDetails["Degree"] as String
                    Degree = findViewById(R.id.Degree)
                    Degree.text = degree
                    val specialization = basicDetails["Specialization"] as String
                    special = findViewById(R.id.special)
                    special.text = specialization
                    val dobb = basicDetails["Date_Of_Birth"] as String
                    dob = findViewById(R.id.dob)
                    dob.text = dobb
                    val dojj = basicDetails["Date_Of_Joining"] as String
                    doj = findViewById(R.id.doj)
                    doj.setText(dojj)
                    val parentname = basicDetails["Name_Of_The_Parent"] as String
                    pname = findViewById(R.id.pname)
                    pname.text = parentname
                    val ppemail = basicDetails["Parent's_Email"] as String
                    pemail = findViewById(R.id.pemail)
                    pemail.text = ppemail
                    val ppphone = basicDetails["Parent's_Phone"] as String
                    pphone = findViewById(R.id.pphone)
                    pphone.text = ppphone.toString()

                    val bloo = basicDetails["Blood_Group"] as String
                    blood = findViewById(R.id.bod)
                    blood.text = bloo
                    val rel = basicDetails["Religion"] as String
                    religion = findViewById(R.id.religion)
                    religion.text = rel
                    val commu = basicDetails["Community"] as String
                    comm = findViewById(R.id.comm)
                    comm.text = commu
                    val fromm = basicDetails["From"] as String
                    from = findViewById(R.id.from)
                    from.text = fromm
                    val too = basicDetails["To"] as String
                    to = findViewById(R.id.to)
                    to.text = too
                    val edu = document!!["Educational_details"]

                    if (edu != null) {
                        edu as Map<*, *>
                        val sslcDetails = edu["SSLC"] as Map<String, Any>?
                        val ssins = sslcDetails?.get("Instituation") as String
                        sins = findViewById(R.id.sins)
                        sins.setText(ssins)
                        val ssmarks = sslcDetails.get("Marks") as String
                        smarks = findViewById(R.id.smarks)
                        smarks.setText(ssmarks)
                        smed = findViewById(R.id.smed)
                        val ssmed = sslcDetails.get("Medium") as String
                        smed.setText(ssmed)
                        syear = findViewById(R.id.syear)
                        val ssyear = sslcDetails.get("Year_Of_Passing") as String
                        syear.setText(ssyear)
                        sboard = findViewById(R.id.sboard)
                        val ssboard = sslcDetails.get("Board") as String
                        sboard.setText(ssboard)

                        val hscDetails = edu["HSC"] as Map<String, Any>?
                        val hhins = hscDetails?.get("Instituation") as String
                        hins = findViewById(R.id.hins)
                        hins.setText(hhins)
                        hmarks = findViewById(R.id.hmarks)
                        val hhmarks = hscDetails.get("Marks") as String
                        hmarks.setText(hhmarks)
                        hmed = findViewById(R.id.hmed)
                        val hhmed = hscDetails.get("Medium") as String
                        hmed.setText(hhmed)
                        hyear = findViewById(R.id.hyear)
                        val hhyear = hscDetails.get("Year_Of_Passing") as String
                        hyear.setText(hhyear)
                        hboard = findViewById(R.id.hboard)
                        val hhboard = hscDetails.get("Board") as String
                        hboard.setText(hhboard)

                        val bscDetails = edu["BSc"] as Map<String, Any>?
                        bins = findViewById(R.id.bins)
                        val bbins = bscDetails?.get("Instituation") as String
                        bins.setText(bbins)
                        bmarks = findViewById(R.id.bmarks)
                        val bbmarks = bscDetails.get("Marks") as String
                        bmarks.setText(bbmarks)
                        bmedi = findViewById(R.id.bmedi)
                        val bbmed = bscDetails.get("Medium") as String
                        bmedi.setText(bbmed)
                        byear = findViewById(R.id.byear)
                        val bbyear = bscDetails.get("Year_Of_Passing") as String
                        byear.setText(bbyear)
                        bboard = findViewById(R.id.bboard)
                        val bbboard = bscDetails.get("Board") as String
                        bboard.setText(bbboard)

                    }

                    val aca = document!!["Academic_details"]

                    if (aca != null) {
                        aca as Map<*, *>
                        val sem1Details = aca["SEM_1"] as Map<String, Any>?
                        val sem1cgpa = sem1Details?.get("CGPA") as String
                        cgpa1.setText(sem1cgpa)
                        val sem1tutor = sem1Details?.get("Tutor_name") as String
                        tutor1.setText(sem1tutor)
                        val sem1res = sem1Details?.get("Residential_Status") as String
                        res1.setText(sem1res)
                        val sem1redo = sem1Details?.get("No_of_redo_courses") as String
                        redo1.setText(sem1redo)
                        val sem1arrear = sem1Details?.get("No_of_arrears") as String
                        arrear1.setText(sem1arrear)

                        val sem2Details = aca["SEM_2"] as Map<String, Any>?
                        val sem2cgpa = sem2Details?.get("CGPA") as String
                        cgpa2.setText(sem2cgpa)
                        val sem2tutor = sem2Details?.get("Tutor_name") as String
                        tutor2.setText(sem2tutor)
                        val sem2res = sem2Details?.get("Residential_Status") as String
                        res2.setText(sem2res)
                        val sem2redo = sem1Details?.get("No_of_redo_courses") as String
                        redo2.setText(sem2redo)
                        val sem2arrear = sem1Details?.get("No_of_arrears") as String
                        arrear2.setText(sem2arrear)

                        val sem3Details = aca["SEM_3"] as Map<String, Any>?
                        val sem3cgpa = sem3Details?.get("CGPA") as String
                        cgpa3.setText(sem3cgpa)
                        val sem3tutor = sem3Details?.get("Tutor_name") as String
                        tutor3.setText(sem3tutor)
                        val sem3res = sem3Details?.get("Residential_Status") as String
                        res3.setText(sem3res)
                        val sem3redo = sem1Details?.get("No_of_redo_courses") as String
                        redo3.setText(sem3redo)
                        val sem3arrear = sem1Details?.get("No_of_arrears") as String
                        arrear3.setText(sem3arrear)

                        val sem4Details = aca["SEM_4"] as Map<String, Any>?
                        val sem4cgpa = sem1Details?.get("CGPA") as String
                        cgpa4.setText(sem4cgpa)
                        val sem4tutor = sem4Details?.get("Tutor_name") as String
                        tutor4.setText(sem4tutor)
                        val sem4res = sem4Details?.get("Residential_Status") as String
                        res4.setText(sem4res)
                        val sem4redo = sem4Details?.get("No_of_redo_courses") as String
                        redo4.setText(sem4redo)
                        val sem4arrear = sem4Details?.get("No_of_arrears") as String
                        arrear4.setText(sem4arrear)


                    }

                }

            }
            Toast.makeText(this, id, Toast.LENGTH_SHORT).show()

            // Use the data to display details on this separate page

        }
    }
}