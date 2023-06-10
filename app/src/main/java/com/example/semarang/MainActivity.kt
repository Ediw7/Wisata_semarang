package com.example.semarang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    var db: DatabaseHelper? = null
    var login: Button? = null
    var register: Button? = null
    var emaillogin: EditText? = null
    var password: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        db = DatabaseHelper(this)
        emaillogin = findViewById(R.id.emaillogin) as EditText?
        password = findViewById(R.id.pass) as EditText?
        login = findViewById(R.id.btn_login) as Button?
        register = findViewById(R.id.btn_register) as Button?

        //register
        register!!.setOnClickListener {
            val registerIntent = Intent(this@MainActivity, Register::class.java)
            startActivity(registerIntent)
            finish()
        }

        //login
        login!!.setOnClickListener {
            val strEmail = emaillogin!!.text.toString()
            val strPassword = password!!.text.toString()
            val masuk: Boolean = db!!.checkLogin(strEmail, strPassword)
            if (masuk == true) {
                val updateSession: Boolean = db!!.upgradeSession("ada", 1)
                if (updateSession == true) {
                    Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT)
                        .show()
                    val mainIntent = Intent(this@MainActivity, MenuUtama::class.java)
                    startActivity(mainIntent)
                    finish()
                }
            } else {
                Toast.makeText(getApplicationContext(), "Masuk Gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
