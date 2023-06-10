package com.example.semarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Simpan : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simpan)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)


        button1.setOnClickListener {
            val intent = Intent(this@Simpan, LawangSewu::class.java)
            finish()
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this@Simpan, KotaLama::class.java)
            finish()
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this@Simpan, SamPoo::class.java)
            finish()
            startActivity(intent)
        }

    }
}