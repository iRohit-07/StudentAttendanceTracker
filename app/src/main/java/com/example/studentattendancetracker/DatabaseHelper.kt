package com.example.studentattendancetracker

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "attendance.db"
        private const val DATABASE_VERSION = 1

        const val TABLE_STUDENTS = "students"
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_ROLL = "roll_no"
        const val COL_STATUS = "status"
    }

    // Runs once, the first time the database is created
    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_STUDENTS (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL_NAME TEXT NOT NULL, " +
                "$COL_ROLL TEXT NOT NULL, " +
                "$COL_STATUS TEXT NOT NULL)"
        db.execSQL(createTable)
    }

    // Runs when DATABASE_VERSION is increased
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
        onCreate(db)
    }

    // Insert one student record; returns the new row id, or -1 on failure
    fun insertStudent(name: String, rollNo: String, status: String): Long {
        val values = ContentValues().apply {
            put(COL_NAME, name)
            put(COL_ROLL, rollNo)
            put(COL_STATUS, status)
        }
        return writableDatabase.insert(TABLE_STUDENTS, null, values)
    }

    // Returns all records as a list of text lines, newest first
    fun getAllStudents(): List<String> {
        val list = mutableListOf<String>()
        val cursor = readableDatabase.rawQuery(
            "SELECT $COL_ID, $COL_NAME, $COL_ROLL, $COL_STATUS FROM $TABLE_STUDENTS ORDER BY CAST($COL_ROLL AS INTEGER) ASC",
            null
        )

        cursor.use {
            while (it.moveToNext()) {
                val id = it.getInt(0)
                val name = it.getString(1)
                val roll = it.getString(2)
                val status = it.getString(3)
                list.add("$id. $name (Roll: $roll) - $status")
            }
        }
        return list
    }
}