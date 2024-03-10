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
import java.time.LocalDate

class FirebaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)

        val database = Firebase.database(
            "https://androidfinalpractice-default-rtdb.asia-southeast1.firebasedatabase.app/"
        )

        val ref = database.getReference("message")
        val studentRef = database.getReference("students")

        studentRef.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val students = snapshot.value.toString()
                Log.d("FirebaseActivity", students)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

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