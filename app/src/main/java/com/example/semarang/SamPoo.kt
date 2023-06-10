package com.example.semarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SamPoo : AppCompatActivity() {
    private lateinit var button7: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sampoo)

        button7 = findViewById(R.id.button7)

        button7.setOnClickListener {
            val intent = Intent(this@SamPoo, MenuUtama::class.java)
            finish()
            startActivity(intent)
        }
    }
}