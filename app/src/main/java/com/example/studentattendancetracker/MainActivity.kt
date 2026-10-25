package com.example.studentattendancetracker

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        private const val PREF_NAME = "AttendancePrefs"
        private const val KEY_FACULTY = "faculty_name"
    }

    private lateinit var etFacultyName: EditText
    private lateinit var tvWelcome: TextView
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var etStudentName: EditText
    private lateinit var etRollNo: EditText
    private lateinit var rgStatus: RadioGroup
    private lateinit var tvRecords: TextView
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainView = findViewById<android.view.View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // Connect views


        etFacultyName = findViewById(R.id.etFacultyName)
        tvWelcome = findViewById(R.id.tvWelcome)
        etStudentName = findViewById(R.id.etStudentName)
        etRollNo = findViewById(R.id.etRollNo)
        rgStatus = findViewById(R.id.rgStatus)
        tvRecords = findViewById(R.id.tvRecords)

        val btnSaveName = findViewById<Button>(R.id.btnSaveName)
        val btnSaveAttendance = findViewById<Button>(R.id.btnSaveAttendance)
        val btnViewRecords = findViewById<Button>(R.id.btnViewRecords)

        // Shared Preferences and SQLite
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        dbHelper = DatabaseHelper(this)

        // Load saved faculty name on startup
        loadFacultyName()

        // Button clicks
        btnSaveName.setOnClickListener { saveFacultyName() }
        btnSaveAttendance.setOnClickListener { saveAttendance() }
        btnViewRecords.setOnClickListener { showRecords() }
    }

    private fun saveFacultyName() {
        val name = etFacultyName.text.toString().trim()

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
            return
        }

        sharedPreferences.edit()
            .putString(KEY_FACULTY, name)
            .apply()

        tvWelcome.text = "Welcome, $name!"
        Toast.makeText(this, "Name saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadFacultyName() {
        val name = sharedPreferences.getString(KEY_FACULTY, "") ?: ""

        if (name.isNotEmpty()) {
            tvWelcome.text = "Welcome, $name!"
            etFacultyName.setText(name)
        }
    }

    private fun saveAttendance() {
        val studentName = etStudentName.text.toString().trim()
        val rollNo = etRollNo.text.toString().trim()

        if (studentName.isEmpty() || rollNo.isEmpty()) {
            Toast.makeText(this, "Enter student name and roll number", Toast.LENGTH_SHORT).show()
            return
        }

        val status = if (rgStatus.checkedRadioButtonId == R.id.rbPresent) "Present" else "Absent"

        val result = dbHelper.insertStudent(studentName, rollNo, status)

        if (result != -1L) {
            Toast.makeText(this, "Attendance saved", Toast.LENGTH_SHORT).show()
            etStudentName.text.clear()
            etRollNo.text.clear()
            etStudentName.requestFocus()
        } else {
            Toast.makeText(this, "Failed to save", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showRecords() {
        val records = dbHelper.getAllStudents()

        if (records.isEmpty()) {
            tvRecords.text = "No records found"
        } else {
            tvRecords.text = records.joinToString("\n")
        }
    }
}