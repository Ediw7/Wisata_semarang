package com.example.semarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LawangSewu : AppCompatActivity() {
    private lateinit var button7: Button
    private lateinit var button8: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lawang_sewu)

        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)

        button7.setOnClickListener {
            val intent = Intent(this@LawangSewu, MenuUtama::class.java)
            finish()
            startActivity(intent)
        }

        button8.setOnClickListener {
            val intent = Intent(this@LawangSewu, Simpan::class.java)
            finish()
            startActivity(intent)
        }
    }
}