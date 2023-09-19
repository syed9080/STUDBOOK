package com.example.projectfinal

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Addr
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Calendar

class student_details : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var dateEditText: EditText
    private lateinit var fname: EditText
    private lateinit var Rollno: EditText
    private lateinit var Degree: EditText
    private lateinit var Special: EditText
    private lateinit var Parent: EditText
    private lateinit var Address: EditText
    private lateinit var Pemail: EditText
    private lateinit var Pphone: EditText
    private val calendar = Calendar.getInstance()
    private lateinit var joindateEditText: EditText
    private val joincalendar = Calendar.getInstance()
    private lateinit var firebaseAuth: FirebaseAuth
    var db= Firebase.firestore
    private  lateinit var Submit:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        firebaseAuth = FirebaseAuth.getInstance()

        //fname
        fname = findViewById(R.id.fname)
        fname.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateUsername()
            }

        }
        //Rollno
        Rollno = findViewById(R.id.Rollno)
        Rollno.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateRollno()
            }

        }
        //Degree
        Degree = findViewById(R.id.Degree)
        Degree.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateDegree()
            }

        }

        //special
        Special = findViewById(R.id.Special)
        Special.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateSpecial()
            }

        }
        //Parent
        Parent = findViewById(R.id.Parent)
        Address=findViewById(R.id.Address)
        Parent.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateParent()
            }

        }
        //Pemail
        Pemail = findViewById(R.id.Pemail)
        Pemail.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validatePemail()
            }

        }
        //Pphone
        Pphone = findViewById(R.id.Pphone)
        Pphone.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validatePphone()
            }

        }
        //selected year spinner
        var selectedYear:String
        selectedYear="none"
        var ToselectedYear:String
        ToselectedYear="none"
        var selectedBloodGroup:String
        selectedBloodGroup="none"
        var selectedReligion:String
        selectedReligion="none"
        var selectedCommunity:String
        selectedCommunity="none"
//        dateEditText.setText("none")
//        joindateEditText.setText("none")


        // details from database

        val uid= FirebaseAuth.getInstance().currentUser?.uid.toString()
        val docRef=db.collection("user").document(uid)
        docRef.get().addOnSuccessListener {document->
            if(document!=null)
            {


                val basicDetails = document!!["Basic_Details"]
                if(basicDetails!=null) {
                    basicDetails  as Map<*, *>
                    val name=basicDetails["Name"] as String
                    fname.setText(name)
                    val address = basicDetails["Address"] as String
                    Address.setText(address)
                    val roll = basicDetails["Roll No"] as String
                    Rollno.setText(roll)
                    val degree = basicDetails["Degree"] as String
                    Degree.setText(degree)
                    val specialization =basicDetails["Specialization"] as String
                    Special.setText(specialization)
                    val dob =basicDetails["Date_Of_Birth"] as String
                    dateEditText.setText(dob)
                    val doj =basicDetails["Date_Of_Joining"] as String
                    joindateEditText.setText(doj)
                    val parentname =basicDetails["Name_Of_The_Parent"] as String
                    Parent.setText(parentname)
                    val pemail =basicDetails["Parent's_Email"] as String
                    Pemail.setText(pemail)
                    val pphone =basicDetails["Parent's_Phone"] as String
                    Pphone.setText(pphone)

                }

            }

        }






        // Create an ArrayAdapter with the years from 1990 to 2028
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
                view: View?,
                position: Int,
                id: Long
            ) {
                 selectedYear = years[position]
                Toast.makeText(
                    this@student_details,
                    "Selected Year: $selectedYear",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
        // Find the Spinner by its ID
        val ToyearSpinner: Spinner = findViewById(R.id.ToyearSpinner)

        // Apply the adapter to the Spinner
        ToyearSpinner.adapter = adapter

        // Handle Spinner item selection here
        ToyearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                    position: Int,
                id: Long
            ) {
                 ToselectedYear = years[position]
                Toast.makeText(
                    this@student_details,
                    "Selected Year: $ToselectedYear",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }


        ///blood group

        val bloodGroupSpinner: Spinner = findViewById(R.id.bloodGroupSpinner)

        // Define the blood group options
        val bloodGroups = arrayOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")

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
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Handle the selected blood group here
                selectedBloodGroup = bloodGroups[position]
                Toast.makeText(
                    this@student_details,
                    "Selected Blood Group: $selectedBloodGroup",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


        //        Religion dropdown

        val religionSpinner: Spinner = findViewById(R.id.religionSpinner)

        // Define the religion options
        val religions =
            arrayOf("Christianity", "Islam", "Hinduism", "Buddhism", "Sikhism", "Judaism", "Other")

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
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Handle the selected blood group here
                selectedReligion = religions[position]
                Toast.makeText(
                    this@student_details,
                    "Selected Religion: $selectedReligion",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })


        //community dropdown


        val communitySpinner: Spinner = findViewById(R.id.communitySpinner)

        // Define the community options
        val communities = arrayOf("BC", "MBC", "DNC", "SC", "ST", "OC", "BCM", "Others")

        // Create an ArrayAdapter using the defined options
        val comadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, communities)

        // Specify the layout to use when the list of choices appears
        comadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        communitySpinner.adapter = comadapter

        communitySpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Handle the selected blood group here
                selectedCommunity = communities[position]
                Toast.makeText(
                    this@student_details,
                    "Selected Community: $selectedCommunity",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        })
        // calender date of birth


        dateEditText = findViewById(R.id.dateEditText)
        joindateEditText = findViewById(R.id.joindateEditText)

        dateEditText.setOnClickListener {
            showDatePickerDialog()
        }
        //add to firebase
        Submit=findViewById(R.id.Submit)
        Submit.setOnClickListener {
            val uid = firebaseAuth.currentUser?.uid.toString()





//        basic details of the student
            val name = fname.text.toString()
            val roll = Rollno.text.toString()
            val degree = Degree.text.toString()
            val specialization = Special.text.toString()
            val year = selectedYear
            val toyear = ToselectedYear
            val dob = dateEditText.text.toString()
            val doj = joindateEditText.text.toString()
            val parentname = Parent.text.toString()
            val Adres = Address.text.toString()
            val pemail = Pemail.text.toString()
            val pphone = Pphone.text.toString()
            val selectcom=selectedCommunity
            val selectreg=selectedReligion
            val selectblood=selectedBloodGroup


            val basic_details = mapOf(
                "Name" to name,
                "Roll No" to roll,
                "Degree" to degree,
                "Specialization" to specialization,
                "From" to year,
                "To" to toyear,
                "Date_Of_Birth" to dob,
                "Date_Of_Joining" to doj,
                "Blood_Group" to selectblood,
                "Religion" to selectreg,
                "Community" to selectcom,
                "Name_Of_The_Parent" to parentname,
                "Address" to Adres,
                "Parent's_Email" to pemail,
                "Parent's_Phone" to pphone
            )

            val basic = mapOf(
                "Basic_Details" to basic_details

            )
            db.collection("user").document(uid).update(basic)



        }
    }

    private fun showDatePickerDialog() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Handle the selected date here
                val selectedDate = "$year-${monthOfYear + 1}-$dayOfMonth"
                dateEditText.setText(selectedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()


        // dateview data of joining

        joindateEditText = findViewById(R.id.joindateEditText)

        joindateEditText.setOnClickListener {
            joinshow()
        }
    }

    private fun joinshow() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val joindatePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Handle the selected date here
                val selectedDate = "$year-${monthOfYear + 1}-$dayOfMonth"
                joindateEditText.setText(selectedDate)
            },
            year,
            month,
            day
        )

        joindatePickerDialog.show()

    }


    //Name validation

    private fun validateUsername() {
        val un = fname.text.toString()
        if (un.isEmpty()) {
            fname.error = "Name cannot be empty"


        } else if (!un.matches(Regex("^[A-Za-z\\s]+\$"))) {
            fname.error = "Name should contain letters only"


        }
    }

    //rollno validatio
    private fun validateRollno() {
        val un = Rollno.text.toString()
        if (un.isEmpty()) {
            Rollno.error = "Rollno cannot be empty"


        } else if (!un.matches(Regex("^\\d{2}[A-Za-z]{1,2}\\d{3}\$"))) {
            Rollno.error = "Please enter a valid roll number"

        }
    }

    //Degree validation
    private fun validateDegree() {
        val un = Degree.text.toString()
        if (un.isEmpty()) {
            Rollno.error = "Degree cannot be empty"


        } else if (!un.matches(Regex("^[A-Za-z\\s]+\$"))) {
            Rollno.error = "Degree should contain letters only"

        }
    }

    //Special validation
    private fun validateSpecial() {
        val un = Special.text.toString()
        if (un.isEmpty()) {
            Special.error = "Specialization cannot be empty"


        } else if (!un.matches(Regex("^[A-Za-z\\s]+\$"))) {
            Special.error = "Specialization should contain letters only"

        }
    }

    //Parent validation
    private fun validateParent() {
        val un = Parent.text.toString()
        if (un.isEmpty()) {
            Parent.error = "Parent name cannot be empty"


        } else if (!un.matches(Regex("^[A-Za-z\\s]+\$"))) {
            Parent.error = "Parent name should contain letters only"

        }
    }

    //Pemail validation
    private fun validatePemail() {
        val un = Pemail.text.toString()
        if (un.isEmpty()) {
            Pemail.error = "Parent email cannot be empty"


        } else if (!un.matches(Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$"))) {
            Pemail.error = "Please enter valid email address"

        }
    }

    //Pphone validation
    private fun validatePphone() {
        val un = Pphone.text.toString()
        if (un.isEmpty()) {
            Pphone.error = "Parent phone cannot be empty"


        } else if (!un.matches(Regex("^\\d{10}\$"))) {
            Pphone.error = "Please enter valid mobile number"
        }

    }
}



