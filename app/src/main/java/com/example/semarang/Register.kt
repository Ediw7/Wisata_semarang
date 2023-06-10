package com.example.semarang

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Register : AppCompatActivity() {
    var db: DatabaseHelper? = null
    var login: Button? = null
    var register: Button? = null
    var email: EditText? = null
    var password: EditText? = null
    var passwordConf: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        db = DatabaseHelper(this)
        email = findViewById(R.id.email) as EditText?
        password = findViewById(R.id.password) as EditText?
        passwordConf = findViewById(R.id.confirmpass) as EditText?
        login = findViewById(R.id.btn_login) as Button?
        register = findViewById(R.id.btn_register) as Button?

        //login
        login!!.setOnClickListener {
            val loginIntent = Intent(this@Register, MainActivity::class.java)
            startActivity(loginIntent)
            finish()
        }

        //register
        register!!.setOnClickListener {
            val strEmail = email!!.text.toString()
            val strPassword = password!!.text.toString()
            val strPasswordConf = passwordConf!!.text.toString()
            if (strPassword == strPasswordConf) {
                val daftar = db!!.insertUser(strEmail, strPassword)
                if (daftar == true) {
                    Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT)
                        .show()
                    val loginIntent = Intent(this@Register, MainActivity::class.java)
                    startActivity(loginIntent)
                    finish()
                } else {
                    Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
