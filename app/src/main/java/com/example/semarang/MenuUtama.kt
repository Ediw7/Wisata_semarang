package com.example.semarang
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuUtama : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_utama)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)

        button1.setOnClickListener {
            val intent = Intent(this@MenuUtama, LawangSewu::class.java)
            finish()
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this@MenuUtama, KotaLama::class.java)
            finish()
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this@MenuUtama, SamPoo::class.java)
            finish()
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this@MenuUtama, Maerokoco::class.java)
            finish()
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent = Intent(this@MenuUtama, Zoo::class.java)
            finish()
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent = Intent(this@MenuUtama, Saloka::class.java)
            finish()
            startActivity(intent)
        }

    }
}