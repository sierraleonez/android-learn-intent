package com.example.learnintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity : Button = findViewById(R.id.btn_mv_activity)
        val btnMoveWithData : Button = findViewById(R.id.btn_mv_with_data)
        val btnMoveWithObject : Button = findViewById(R.id.btn_mv_with_object)
        val btnDialNumber : Button = findViewById(R.id.btn_dial_number)

        btnMoveActivity.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_mv_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_mv_with_data -> {
                val moveIntentWithData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveIntentWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveIntentWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveIntentWithData)
            }
            R.id.btn_mv_with_object -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.id",
                    "Bandung"
                )

                val moveObjectWithintent = Intent(this@MainActivity, MoveWithObject::class.java)
                moveObjectWithintent.putExtra(MoveWithObject.EXTRA_PERSON, person)
                startActivity(moveObjectWithintent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "082242404797"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}