package com.example.semarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Maerokoco : AppCompatActivity() {
    private lateinit var button7: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maerokoco)

        button7 = findViewById(R.id.button7)

        button7.setOnClickListener {
            val intent = Intent(this@Maerokoco, MenuUtama::class.java)
            finish()
            startActivity(intent)
        }

    }
}