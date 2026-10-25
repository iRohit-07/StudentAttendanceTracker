# 🎓 Student Attendance Tracker

A simple and user-friendly Android application developed as part of a **Mobile Application Development (MAD) lab activity** to demonstrate data persistence using **Shared Preferences and SQLite Database**.

The application helps users manage student information, record attendance, and maintain attendance records locally on their devices.

## 📌 Project Overview

The Student Attendance Tracker is designed to simplify attendance management for students and teachers. Users can add student details, mark attendance, view attendance records, and manage saved information through a simple interface.

The application demonstrates how Android applications can store and retrieve data using Shared Preferences and SQLite, ensuring that saved information remains available even after the application is closed and reopened.

## ✨ Features

- 👨‍🎓 **Student Management:** Add and manage student information.
- ✅ **Attendance Marking:** Mark students as present or absent.
- 📋 **Attendance Records:** View previously saved attendance information.
- 📊 **Attendance Percentage:** Calculate attendance percentages, if implemented.
- 💾 **Data Persistence:** Retain saved information after restarting the application.
- ⚙️ **Shared Preferences:** Store application settings and small pieces of key-value data.
- 🗄️ **SQLite Database:** Store structured student and attendance records.
- 📱 **Simple User Interface:** Easy-to-use Android interface.

## 🛠️ Technologies Used

- **Platform:** Android
- **IDE:** Android Studio
- **Programming Language:** Kotlin
- **Database:** SQLite
- **Local Storage:** Shared Preferences
- **UI:** XML Layouts and Android UI Components
- **Version Control:** Git and GitHub

*Note: Adjust the programming language and UI technologies if your project uses Java or Jetpack Compose instead.*

## 💾 Data Persistence

This project demonstrates two methods of local data storage.

### 1. Shared Preferences

Shared Preferences is used to store small amounts of data as key-value pairs.

**Possible uses in this application:**
- Save the selected subject or semester.
- Store user preferences.
- Remember application settings.

### 2. SQLite Database

SQLite is used to store structured data in a local database.

**Possible uses in this application:**
- Store student information.
- Save attendance records.
- Retrieve previously saved attendance details.
- Update or delete records when required.

### Data Persistence Demonstration

1. Open the application.
2. Add student information and mark attendance.
3. Close the application.
4. Reopen the application.
5. Verify that the saved information is still available.

This demonstrates that data persists beyond the application's current session.

## 📸 Screenshots

### 1. Home Screen
Displays the main dashboard of the Student Attendance Tracker.

![Home Screen](screenshots/ss1.png)

### 2. Student Management / Attendance Screen
Displays student information and attendance-marking options.

![Attendance Screen](screenshots/ss2.png)

### 3. Attendance Records Screen
Displays saved attendance records.

![Attendance Records](screenshots/ss3.png)


## 🎯 Learning Objectives

This project helps demonstrate the following concepts:

- Understanding local data persistence in Android.
- Implementing Shared Preferences.
- Creating and managing an SQLite database.
- Performing basic database operations.
- Saving and retrieving attendance information.
- Designing an Android application interface.
- Understanding the difference between key-value storage and relational database storage.

## 🔮 Future Enhancements

The application can be extended with the following features:

- Student search and filtering.
- Subject-wise attendance management.
- Date-wise attendance reports.
- Export attendance reports to PDF or Excel.
- Attendance reminders.
- Improved user interface and accessibility.
- Cloud backup and synchronization.


**Result:** The Student Attendance Tracker demonstrates local data persistence by storing application preferences and structured attendance information. Saved data can be retrieved across application sessions, provided the application data is not cleared or the application is uninstalled.

## 👨‍💻 Author
Rohit Kumar Singh
USN - 25MCAR0306

**Student Attendance Tracker**
