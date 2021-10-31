package com.example.learnintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObject : AppCompatActivity() {
    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvResult : TextView = findViewById(R.id.tvResultObject)
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Nama : ${person.name.toString()} age : ${person.age} email : ${person.email} city : ${person.city}"
        tvResult.text = text

    }
}