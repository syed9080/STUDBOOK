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
import com.google.firebase.database.core.view.View
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Educational_details : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var db= Firebase.firestore
    private lateinit var firebaseAuth: FirebaseAuth
    private  lateinit var Submit: Button
    private lateinit var sins: EditText
    private lateinit var smarks: EditText
    private lateinit var hins: EditText
    private lateinit var hmarks: EditText
    private lateinit var bins: EditText
    private lateinit var bmarks: EditText
    private lateinit var uid:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_educational_details)


        var selectedBloodGroup: String
        selectedBloodGroup = "none"
        var selectedYear: String
        selectedYear = "none"
        var selectedReligion: String
        selectedReligion = "none"
        sins = findViewById(R.id.sins)
        smarks = findViewById(R.id.smarks)
        hins = findViewById(R.id.hins)
        hmarks = findViewById(R.id.hmarks)
        bins = findViewById(R.id.bins)
        bmarks = findViewById(R.id.bmarks)
        var pr=0
        var pm=0
        var py=0
        var phr=0
        var phm=0
        var phy=0
        var pbr=0
        var pbm=0
        var pby=0


        sins.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validatesins()
            }

        }
            smarks.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validatesmarks()
            }

        }
        hins.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validatehins()
            }

        }
        hmarks.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validatehmarks()
            }

        }
        bins.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validatebins()
            }

        }
        bmarks.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validatebmarks()
            }

        }

        ///blood group
        val bloodGroupSpinner: Spinner = findViewById(R.id.bloodGroupSpinner)

        // Define the blood group options
        val bloodGroups = arrayOf("Tamil", "English")

        // Create an ArrayAdapter using the defined options
        val bloodadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bloodGroups)

        // Specify the layout to use when the list of choices appears
        bloodadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        bloodGroupSpinner.adapter = bloodadapter

        // Handle Spinner item selection here
        bloodGroupSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {
                pm=position
                // Handle the selected blood group here
                selectedBloodGroup = bloodGroups[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


        val years = (1990..2028).map { it.toString() }.toTypedArray()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Find the Spinner by its ID
        val yearSpinner: Spinner = findViewById(R.id.yearSpinner)

        // Apply the adapter to the Spinner
        yearSpinner.adapter = adapter

        // Handle Spinner item selection here
        yearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                py=position
                selectedYear = years[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }


        val religionSpinner: Spinner = findViewById(R.id.religionSpinner)

        // Define the religion options
        val religions =
            arrayOf("ICSE", "CBSE", "STATE BOARD")

        // Create an ArrayAdapter using the defined options
        val reladapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, religions)

        // Specify the layout to use when the list of choices appears
        reladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        religionSpinner.adapter = reladapter
        // Handle Spinner item selection here
        religionSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: android.view.View?,
                position: Int,
                id: Long
            ) {
                pr=position
                // Handle the selected blood group here
                selectedReligion = religions[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


        //hsc details

        var hselectedBloodGroup: String
        hselectedBloodGroup = "none"
        var hselectedYear: String
        hselectedYear = "none"
        var hselectedReligion: String
        hselectedReligion = "none"

        ///blood group
        val hbloodGroupSpinner: Spinner = findViewById(R.id.hbloodGroupSpinner)

        // Define the blood group options
        val hbloodGroups = arrayOf("Tamil", "English")

        // Create an ArrayAdapter using the defined options
        val hbloodadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hbloodGroups)

        // Specify the layout to use when the list of choices appears
        hbloodadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        hbloodGroupSpinner.adapter = hbloodadapter

        // Handle Spinner item selection here
        hbloodGroupSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {
                phm=position
                // Handle the selected blood group here
                hselectedBloodGroup = hbloodGroups[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


        val hyears = (1990..2028).map { it.toString() }.toTypedArray()
        val hadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hyears)

        // Specify the layout to use when the list of choices appears
        hadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Find the Spinner by its ID
        val hyearSpinner: Spinner = findViewById(R.id.hyearSpinner)

        // Apply the adapter to the Spinner
        hyearSpinner.adapter = hadapter

        // Handle Spinner item selection here
        hyearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            )
            {
                phy=position

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
        val hreligionSpinner: Spinner = findViewById(R.id.hreligionSpinner)

        // Define the religion options
        val hreligions =
            arrayOf("ICSE", "CBSE", "STATE BOARD")

        // Create an ArrayAdapter using the defined options
        val hreladapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, religions)

        // Specify the layout to use when the list of choices appears
        hreladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        hreligionSpinner.adapter = reladapter
        // Handle Spinner item selection here
        hreligionSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: android.view.View?,
                position: Int,
                id: Long
            ) {
                phr=position
                // Handle the selected blood group here
                hselectedReligion = hreligions[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


        var bselectedBloodGroup: String
        bselectedBloodGroup = "none"
        var bselectedYear: String
        bselectedYear = "none"
        var bselectedReligion: String
        bselectedReligion = "none"

        ///blood group
        val bbloodGroupSpinner: Spinner = findViewById(R.id.bbloodGroupSpinner)

        // Define the blood group options
        val bbloodGroups = arrayOf("Tamil", "English")

        // Create an ArrayAdapter using the defined options
        val bbloodadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bbloodGroups)

        // Specify the layout to use when the list of choices appears
        bbloodadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        bbloodGroupSpinner.adapter = bbloodadapter

        // Handle Spinner item selection here
        bbloodGroupSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                p1: android.view.View?,
                position: Int,
                id: Long
            ) {
                pbm=position
                // Handle the selected blood group here
                bselectedBloodGroup = bbloodGroups[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


        val byears = (1990..2028).map { it.toString() }.toTypedArray()
        val badapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, byears)

        // Specify the layout to use when the list of choices appears
        badapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Find the Spinner by its ID
        val byearSpinner: Spinner = findViewById(R.id.byearSpinner)

        // Apply the adapter to the Spinner
        byearSpinner.adapter = badapter

        // Handle Spinner item selection here
        byearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                pbr=position
                bselectedYear = years[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }


        val breligionSpinner: Spinner = findViewById(R.id.breligionSpinner)

        // Define the religion options
        val breligions =arrayOf("BCA", "BSc", "BBA")

        // Create an ArrayAdapter using the defined options
        val breladapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, breligions)

        // Specify the layout to use when the list of choices appears
        breladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        breligionSpinner.adapter = breladapter
        // Handle Spinner item selection here
        breligionSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: android.view.View?,
                position: Int,
                id: Long
            ) {
                pbr=0
                // Handle the selected blood group here
                bselectedReligion = breligions[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


//firebase
        val message = intent.getStringExtra("Id")?.toString()
        if(message!=null)
        {
            Toast.makeText(this,"wrong",Toast.LENGTH_SHORT).show()
            uid=message
        }
        else {
            Toast.makeText(this,"correct executer",Toast.LENGTH_SHORT).show()
            uid = FirebaseAuth.getInstance().uid.toString()
        }
        Submit=findViewById(R.id.Submit)
        Submit.setOnClickListener {
            firebaseAuth = FirebaseAuth.getInstance()

        // basic details of the student

            val board=selectedReligion
            val medium=selectedBloodGroup
            val year=selectedYear
            val hboard=hselectedReligion
            val hmedium=hselectedBloodGroup
            val hyear=hselectedYear
            val bboard=bselectedReligion
            val bmedium=bselectedBloodGroup
            val byear=bselectedYear
            val ins = sins.text.toString()
            val marks = smarks.text.toString()
            val bbins = bins.text.toString()
            val bbmarks = bmarks.text.toString()
            val hhins = hins.text.toString()
            val hhmarks = hmarks.text.toString()
            val ssls= mapOf(
                "Medium" to medium,
                "Year_Of_Passing" to year,
                "Board" to board,
                "Instituation" to ins,
                "Marks" to marks,
                "Mediumpos" to pm,
                "Boardpos" to pr,
                "Yearpos" to py
            )
            val hsc= mapOf(
                "Medium" to hmedium,
                "Year_Of_Passing" to hyear,
                "Board" to hboard,
                "Instituation" to hhins,
                "Marks" to hhmarks,
                "Mediumpos" to phm,
                "Boardpos" to phr,
                "Yearpos" to phy)
            val bsc= mapOf(
                "Medium" to bmedium,
                "Year_Of_Passing" to byear,
                "Board" to bboard,
                "Instituation" to bbins,
                "Marks" to bbmarks,
                "Mediumpos" to pbm,
                "Boardpos" to pbr,
                "Yearpos" to pby
            )
            val education= mapOf(
                "SSLC" to ssls,
                "HSC" to hsc,
                "BSc" to bsc
            )
            val educations= mapOf(
                "Educational_details" to education
            )
            db.collection("user").document(uid).update(educations)

        }

        //fetch from database

        val docRef=db.collection("user").document(uid)
        docRef.get().addOnSuccessListener {document->
            if(document!=null)
            {


                val edu= document!!["Educational_details"]

                if(edu!=null) {
                    edu  as Map<*, *>
                    val sslcDetails = edu["SSLC"] as Map<String, Any>?
                    val ssins= sslcDetails?.get("Instituation") as String
                    sins.setText(ssins)
                    val ssmarks=sslcDetails.get("Marks") as String
                    smarks.setText(ssmarks)
                    selectedYear=sslcDetails.get("Year_Of_Passing") as String
                    val hscDetails = edu["HSC"] as Map<String, Any>?
                    val hhins= hscDetails?.get("Instituation") as String
                    hins.setText(hhins)
                    val hhmarks=hscDetails.get("Marks") as String
                    hmarks.setText(hhmarks)
                    hselectedYear=hscDetails.get("Year_Of_Passing") as String
                    val bscDetails = edu["BSc"] as Map<String, Any>?
                    val bbins= bscDetails?.get("Instituation") as String
                    bins.setText(bbins)
                    val bbmarks=bscDetails.get("Marks") as String
                    bmarks.setText(bbmarks)
                    bselectedYear=bscDetails.get("Year_Of_Passing") as String
                }

            }

        }


        }
    private fun validatesins() {
        val un = sins.text.toString()
        if (un.isEmpty()) {
            sins.error = "Institution cannot be empty"


        } else if (!un.matches(Regex("^[A-Za-z\\s]+\$"))) {
            sins.error = "Please enter valid Institution"
        }

    }
    private fun validatesmarks() {
        val un = smarks.text.toString()
        if (un.isEmpty()) {
            smarks.error = "Marks cannot be empty"


        } else if (!un.matches(Regex("^\\d{1,5}(?:\\.\\d+)?\$"))) {
            smarks.error = "Please enter valid Marks"
        }

    }
    private fun validatehins() {
        val un = hins.text.toString()
        if (un.isEmpty()) {
            hins.error = "Institution cannot be empty"


        } else if (!un.matches(Regex("^[A-Za-z\\s]+\$"))) {
            hins.error = "Please enter valid Institution"
        }

    }
    private fun validatehmarks() {
        val un = hmarks.text.toString()
        if (un.isEmpty()) {
            hmarks.error = "Parent phone cannot be Marks"


        } else if (!un.matches(Regex("^\\d{1,5}(?:\\.\\d+)?\$"))) {
            hmarks.error = "Please enter valid Marks"
        }

    }
    private fun validatebins() {
        val un = bins.text.toString()
        if (un.isEmpty()) {
            bins.error = "Institution cannot be empty"


        } else if (!un.matches(Regex("^[A-Za-z\\s]+\$"))) {
            bins.error = "Please enter valid institution"
        }

    }
    private fun validatebmarks() {
        val un = bmarks.text.toString()
        if (un.isEmpty()) {
            bmarks.error = "Marks cannot be empty"


        } else if (!un.matches(Regex("^\\d{1,5}(?:\\.\\d+)?\$"))) {
            bmarks.error = "Please enter valid Marks"
        }

    }
    }
