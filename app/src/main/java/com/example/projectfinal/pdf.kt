package com.example.projectfinal

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.*
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream

class pdf : AppCompatActivity() {

    // Initialize variables
    private lateinit var generatePDFBtn: Button
    private var pageHeight = 1120
    private var pageWidth = 792
    private lateinit var bmp: Bitmap
    private lateinit var scaledbmp: Bitmap

    // Request code for permissions
    private val PERMISSION_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)
        val message=intent.getStringExtra("Id")

        // Initialize button
        generatePDFBtn = findViewById(R.id.idBtnGeneratePdf)

        bmp = BitmapFactory.decodeResource(resources, R.drawable.android)
        scaledbmp = Bitmap.createScaledBitmap(bmp, 140, 140, false)

        // Check and request permissions
        if (checkPermissions()) {
            Toast.makeText(this, "Permissions Granted..", Toast.LENGTH_SHORT).show()
        } else {
            requestPermission()
        }

        generatePDFBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                generatePDF()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun generatePDF() {
        val message=intent.getStringExtra("Id")
        val pdfDocument = PdfDocument()
        val paint = Paint()
        val title = Paint()
        val myPageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
        val myPage = pdfDocument.startPage(myPageInfo)
        val canvas = myPage.canvas

        canvas.drawBitmap(scaledbmp, 56F, 40F, paint)
        title.textSize = 15F
        title.color = Color.BLACK

        if (message != null) {
            canvas.drawText(message, 209F, 100F, title)
        }
        canvas.drawText("syed", 209F, 80F, title)
        title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
        title.color = Color.BLACK
        title.textSize = 15F
        title.textAlign = Paint.Align.CENTER
        canvas.drawText("This is a sample document created with permission.", 396F, 560F, title)

        pdfDocument.finishPage(myPage)
        val file = File(getExternalFilesDir(null), "${message}.pdf")

        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(applicationContext, "PDF file generated.", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(applicationContext, "Failed to generate PDF file.", Toast.LENGTH_SHORT).show()
        }
        pdfDocument.close()
    }

    private fun checkPermissions(): Boolean {
        val writeStoragePermission = ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return writeStoragePermission == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permission Denied.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
