*Personal Task Manager – Android Task Manager App

Personal Task Manager is a lightweight, offline-first Android application built using Kotlin and Room Database. It allows users to organize daily tasks with ease — add, edit, delete, and mark them as completed — all within a clean and modern user interface.

*About the Project

This project, originally developed as part of a Final Exam for Creative IT Institute, focuses on understanding the fundamentals of Android app development and local data management using Kotlin and Room. The goal was to create a fully functional, user-friendly task management app that works entirely offline.

Tech Stack
Category :	Tools & Libraries
Language :	Kotlin
Database :	Room Database
UI Components :	RecyclerView, CardView, FloatingActionButton
Design Framework :	Material Design
Utilities :	View Binding, DatePicker, SearchView, AlertDialog
Additional Libraries :	Room, Kapt, SwipeRefreshLayout, Parcelable
Key Features 

*Add new tasks

Edit and update existing tasks

Delete tasks with confirmation dialogs

Mark tasks as completed

Choose due dates using a date picker

Fully offline functionality using a local Room database

Swipe down to refresh the task list

System Architecture
Data Layer

Implemented using Room Database

Includes an Entity, DAO, and Database class

*Example entity:

@Entity
@Parcelize
data class Data(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val title: String,
    val description : String,
    val date: String

    ): Parcelable

*UI Layer

Task list displayed using RecyclerView

Separate screens for adding, editing, and viewing tasks

Designed with Material Design principles for an intuitive user experience

Challenges and Solutions
Problem	Solution
Room dependency error	Added kapt plugin in Gradle build file
RecyclerView not refreshing	Used notifyDataSetChanged() after data changes
Date format inconsistency	Applied SimpleDateFormat with correct Locale
SearchView reset issue	Manually cleared search query logic
User Interface Highlights

Clean and minimal Material Design layout

Swipe down to refresh

Toasts and dialogs for user feedback

Purple and black accent theme with rounded card corners

What I Learned

Setting up and using Room Database

Building and managing custom RecyclerView adapters

Implementing View Binding for safer and cleaner UI handling

Managing Android Activity lifecycle

Debugging with Logcat

Writing maintainable and well-documented Kotlin code

Future Enhancements

Task categories and priority levels

Reminder notifications

Cloud synchronization using Firebase

Dark mode support

Task statistics and progress visualization

Swipe gestures for quick actions

*Conclusion

Developing the Personal Task Manager provided valuable hands-on experience in Android app development — from creating user interfaces with Material Design to implementing a robust local database using Room. It reinforced the importance of practical learning through
real projects and problem-solving.

*Screenshots
<p float="left">
  <img src="https://github.com/user-attachments/assets/b6571358-cad1-444d-9e8e-5dd4b43ff2eb" width="200" />
  <img src="https://github.com/user-attachments/assets/cca10e42-87be-4044-be21-1fd303568f67" width="200" />
  <img src="https://github.com/user-attachments/assets/0b194046-1531-4112-b415-ef583699c11d" width="200" />
  <img src="https://github.com/user-attachments/assets/a15ee914-2478-4494-bcc9-a37b388ef7d3" width="200" />
</p>

