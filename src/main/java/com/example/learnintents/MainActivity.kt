package com.example.learnintents

import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult : TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if (result.resultCode == MoveWithResultAcivity.RESULT_CODE && result.data != null){
            val selectedValue =
                result.data?.getIntExtra(MoveWithResultAcivity.EXTRA_SELECTED_VALUE,0)
            tvResult.text = "Hasil : ${selectedValue}"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity : Button = findViewById(R.id.btn_mv_activity)
        val btnMoveWithData : Button = findViewById(R.id.btn_mv_with_data)
        val btnMoveWithObject : Button = findViewById(R.id.btn_mv_with_object)
        val btnDialNumber : Button = findViewById(R.id.btn_dial_number)
        val btnMoveforResult : Button = findViewById(R.id.btn_move_for_result)
        tvResult = findViewById(R.id.tv_result)

        btnMoveActivity.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveforResult.setOnClickListener(this)



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

            R.id.btn_move_for_result -> {
                val moveResultIntent = Intent(this@MainActivity, MoveWithResultAcivity::class.java)
                resultLauncher.launch(moveResultIntent)
            }
        }
    }
}