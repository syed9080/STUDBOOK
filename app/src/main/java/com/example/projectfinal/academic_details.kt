package com.example.projectfinal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class academic_details : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private  lateinit var tutorSem1 : EditText
    private lateinit var tutorSem2 :EditText
    private lateinit var tutorSem3 :EditText
    private lateinit var tutorSem4 :EditText
    private lateinit var cgpa1 : EditText
    private lateinit var cgpa2 : EditText
    private lateinit var cgpa3 : EditText
    private lateinit var cgpa4 : EditText
    private lateinit var Submit1 :Button
    var db= Firebase.firestore
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var uid:String



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_academic_details)
        tutorSem1 = findViewById(R.id.title)
        tutorSem2 = findViewById(R.id.editTextText19)
        tutorSem3 = findViewById(R.id.editTextText15)
        tutorSem4 = findViewById(R.id.editTextText20)
        cgpa1 = findViewById(R.id.editTextText18)
        cgpa2 = findViewById(R.id.editTextText27)
        cgpa3 = findViewById(R.id.editTextText47)
        cgpa4 = findViewById(R.id.editTextText60)


        var hselectedResidental: String
        hselectedResidental = "none"
        var hselectedResidental1: String
        hselectedResidental1 = "none"
        var hselectedResidental2: String
        hselectedResidental2 = "none"
        var hselectedResidental3: String
        hselectedResidental3 = "none"
        var hselectedArrear: String
        hselectedArrear = "none"
        var hselectedArrear1: String
        hselectedArrear1 = "none"
        var hselectedArrear2: String
        hselectedArrear2 = "none"
        var hselectedArrear3: String
        hselectedArrear3 = "none"
        var hselectedredo: String
        hselectedredo = "none"
        var hselectedredo1: String
        hselectedredo1 = "none"
        var hselectedredo2: String
        hselectedredo2 = "none"
        var hselectedredo3: String
        hselectedredo3 = "none"




///blood group
        val ResidentalSpinner: Spinner = findViewById(R.id.ResidentalSpinner)

// Define the blood group options
        val ResidentalGroup = arrayOf("Hosteller", "Day scholar")

// Create an ArrayAdapter using the defined options
        val Residentaladapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ResidentalGroup)

// Specify the layout to use when the list of choices appears
        Residentaladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        ResidentalSpinner.adapter = Residentaladapter

// Handle Spinner item selection here
        ResidentalSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedResidental = ResidentalGroup[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val ResidentalSpinner1: Spinner = findViewById(R.id.ResidentalSpinner1)

// Define the blood group options
        val ResidentalGroup1 = arrayOf("Hosteller", "Day scholar")

// Create an ArrayAdapter using the defined options
        val Residentaladapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, ResidentalGroup1)

// Specify the layout to use when the list of choices appears
        Residentaladapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        ResidentalSpinner1.adapter = Residentaladapter1

// Handle Spinner item selection here
        ResidentalSpinner1.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedResidental1 = ResidentalGroup1[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
        ///blood group
        val ResidentalSpinner2: Spinner = findViewById(R.id.ResidentalSpinner2)

// Define the blood group options
        val ResidentalGroup2 = arrayOf("Hosteller", "Day scholar")

// Create an ArrayAdapter using the defined options
        val Residentaladapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, ResidentalGroup2)

// Specify the layout to use when the list of choices appears
        Residentaladapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        ResidentalSpinner2.adapter = Residentaladapter2

// Handle Spinner item selection here
        ResidentalSpinner2.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedResidental2 = ResidentalGroup2[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
        ///blood group
        val ResidentalSpinner3: Spinner = findViewById(R.id.ResidentalSpinner3)

// Define the blood group options
        val ResidentalGroup3 = arrayOf("Hosteller", "Day scholar")

// Create an ArrayAdapter using the defined options
        val Residentaladapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, ResidentalGroup3)

// Specify the layout to use when the list of choices appears
        Residentaladapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        ResidentalSpinner3.adapter = Residentaladapter3

// Handle Spinner item selection here
        ResidentalSpinner3.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedResidental3 = ResidentalGroup3[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val ArrearSpinner: Spinner = findViewById(R.id.ArrearSpinner)

// Define the blood group options
        val ArrearGroup = arrayOf("0","1", "2","3","4","5","6","7","8","9","10")

// Create an ArrayAdapter using the defined options
        val Arrearadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrearGroup)

// Specify the layout to use when the list of choices appears
        Arrearadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        ArrearSpinner.adapter = Arrearadapter

// Handle Spinner item selection here
        ArrearSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedArrear = ArrearGroup[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val ArrearSpinner1: Spinner = findViewById(R.id.ArrearSpinner1)

// Define the blood group options
        val ArrearGroup1 = arrayOf("0","1", "2","3","4","5","6","7","8","9","10")

// Create an ArrayAdapter using the defined options
        val Arrearadapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrearGroup1)

// Specify the layout to use when the list of choices appears
        Arrearadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        ArrearSpinner1.adapter = Arrearadapter1

// Handle Spinner item selection here
        ArrearSpinner1.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedArrear1 = ArrearGroup1[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val ArrearSpinner2: Spinner = findViewById(R.id.ArrearSpinner2)

// Define the blood group options
        val ArrearGroup2 = arrayOf("0","1", "2","3","4","5","6","7","8","9","10")

// Create an ArrayAdapter using the defined options
        val Arrearadapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrearGroup2)

// Specify the layout to use when the list of choices appears
        Arrearadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        ArrearSpinner2.adapter = Arrearadapter2

// Handle Spinner item selection here
        ArrearSpinner2.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedArrear2 = ArrearGroup2[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val ArrearSpinner3: Spinner = findViewById(R.id.ArrearSpinner3)

// Define the blood group options
        val ArrearGroup3 = arrayOf("0","1", "2","3","4","5","6","7","8","9","10")

// Create an ArrayAdapter using the defined options
        val Arrearadapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrearGroup3)

// Specify the layout to use when the list of choices appears
        Arrearadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        ArrearSpinner3.adapter = Arrearadapter3

// Handle Spinner item selection here
        ArrearSpinner3.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedArrear3 = ArrearGroup3[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val RedoSpinner: Spinner = findViewById(R.id.RedoSpinner)

// Define the blood group options
        val RedoGroup = arrayOf("0","1", "2","3","4","5","6","7","8","9","10")

// Create an ArrayAdapter using the defined options
        val Redoadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, RedoGroup)

// Specify the layout to use when the list of choices appears
        Redoadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        RedoSpinner.adapter = Redoadapter

// Handle Spinner item selection here
        RedoSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedredo = RedoGroup[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val RedoSpinner1: Spinner = findViewById(R.id.RedoSpinner1)

// Define the blood group options
        val RedoGroup1 = arrayOf("0","1", "2","3","4","5","6","7","8","9","10")

// Create an ArrayAdapter using the defined options
        val Redoadapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, RedoGroup1)

// Specify the layout to use when the list of choices appears
        Redoadapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        RedoSpinner1.adapter = Redoadapter1

// Handle Spinner item selection here
        RedoSpinner1.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedredo1 = RedoGroup1[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val RedoSpinner2: Spinner = findViewById(R.id.RedoSpinner2)

// Define the blood group options
        val RedoGroup2 = arrayOf("0","1", "2","3","4","5","6","7","8","9","10")

// Create an ArrayAdapter using the defined options
        val Redoadapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, RedoGroup2)

// Specify the layout to use when the list of choices appears
        Redoadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        RedoSpinner2.adapter = Redoadapter2

// Handle Spinner item selection here
        RedoSpinner2.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedredo2 = RedoGroup2[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
///blood group
        val RedoSpinner3: Spinner = findViewById(R.id.RedoSpinner3)

// Define the blood group options
        val RedoGroup3 = arrayOf("0","1", "2","3","4","5","6","7","8","9","10")

// Create an ArrayAdapter using the defined options
        val Redoadapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, RedoGroup3)

// Specify the layout to use when the list of choices appears
        Redoadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        RedoSpinner3.adapter = Redoadapter3

// Handle Spinner item selection here
        RedoSpinner3.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {

                // Handle the selected blood group here
                hselectedredo3 = RedoGroup3[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


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

        //firebase
        Submit1=findViewById(R.id.Submit1)
        Submit1.setOnClickListener {
            firebaseAuth = FirebaseAuth.getInstance()





            // basic details of the student

            val rsem1=hselectedResidental
            val rsem2=hselectedResidental1
            val rsem3=hselectedResidental2
            val rsem4=hselectedResidental3
            val tsem1=tutorSem1.text.toString()
            val tsem2=tutorSem2.text.toString()
            val tsem3=tutorSem3.text.toString()
            val tsem4=tutorSem4.text.toString()
            val asem1=hselectedArrear
            val asem2=hselectedArrear1
            val asem3=hselectedArrear2
            val asem4=hselectedArrear3
            val resem1=hselectedredo
            val resem2=hselectedredo1
            val resem3=hselectedredo2
            val resem4=hselectedredo3
            val csem1=cgpa1.text.toString()
            val csem2=cgpa2.text.toString()
            val csem3=cgpa3.text.toString()
            val csem4=cgpa4.text.toString()


            val sem1= mapOf(
                "Residential_Status" to rsem1,
                "Tutor_name" to tsem1,
                "No_of_arrears" to asem1,
                "No_of_redo_courses" to resem1,
                "CGPA" to csem1
            )
            val sem2= mapOf(
                "Residential_Status" to rsem2,
                "Tutor_name" to tsem2,
                "No_of_arrears" to asem2,
                "No_of_redo_courses" to resem2,
                "CGPA" to csem2
            )
            val sem3= mapOf(
                "Residential_Status" to rsem3,
                "Tutor_name" to tsem3,
                "No_of_arrears" to asem3,
                "No_of_redo_courses" to resem3,
                "CGPA" to csem3
            )
            val sem4= mapOf(
                "Residential_Status" to rsem4,
                "Tutor_name" to tsem4,
                "No_of_arrears" to asem4,
                "No_of_redo_courses" to resem4,
                "CGPA" to csem4
            )
            val semester= mapOf(
                "SEM_1" to sem1,
                "SEM_2" to sem2,
                "SEM_3" to sem3,
                "SEM_4" to sem4
            )
            val academic_details= mapOf(
                "Academic_details" to semester
             )
            db.collection("user").document(uid).update(academic_details)

        }

//        fetch from database

        val docRef=db.collection("user").document(uid)


        docRef.get().addOnSuccessListener {document->
            if(document!=null)
            {


                val aca= document!!["Academic_details"]

                if(aca!=null) {
                    aca  as Map<*, *>
                    val sem1Details = aca["SEM_1"] as Map<String, Any>?
                    val sem1cgpa= sem1Details?.get("CGPA") as String
                    cgpa1.setText(sem1cgpa)
                    val sem1tutor= sem1Details?.get("Tutor_name") as String
                    tutorSem1.setText(sem1tutor)

                    val sem2Details = aca["SEM_2"] as Map<String, Any>?
                    val sem2cgpa= sem2Details?.get("CGPA") as String
                    cgpa2.setText(sem2cgpa)
                    val sem2tutor= sem2Details?.get("Tutor_name") as String
                    tutorSem2.setText(sem2tutor)

                    val sem3Details = aca["SEM_3"] as Map<String, Any>?
                    val sem3cgpa= sem3Details?.get("CGPA") as String
                    cgpa3.setText(sem3cgpa)
                    val sem3tutor= sem3Details?.get("Tutor_name") as String
                    tutorSem3.setText(sem3tutor)

                    val sem4Details = aca["SEM_4"] as Map<String, Any>?
                    val sem4cgpa= sem4Details?.get("CGPA") as String
                    cgpa4.setText(sem4cgpa)
                    val sem4tutor= sem4Details?.get("Tutor_name") as String
                    tutorSem4.setText(sem4tutor)

                }

            }

        }



    }
}

