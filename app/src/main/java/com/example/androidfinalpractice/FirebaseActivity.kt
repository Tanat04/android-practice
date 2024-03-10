package com.example.androidfinalpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.gson.Gson
import java.time.LocalDate

class FirebaseActivity : AppCompatActivity() {

    data class FirebaseStudent(
        val studentName: String? = null,
        val grade: Double? = null,
        val title: String? = null
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)

        val database = Firebase.database(
            "https://androidfinalpractice-default-rtdb.asia-southeast1.firebasedatabase.app/"
        )

        val ref = database.getReference("message")
        val studentRef = database.getReference("students").child("1")

        studentRef.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val student = snapshot.getValue(FirebaseStudent::class.java)

                Toast.makeText(this@FirebaseActivity, "My name is ${student?.studentName}", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {}

        })

        ref.setValue("Current time is ${LocalDate.now()}")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Toast.makeText(this@FirebaseActivity, snapshot.value.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}