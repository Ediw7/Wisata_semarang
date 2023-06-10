package com.example.semarang

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, "wisatasemarang.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)")
        db.execSQL("CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT, email text, password text)")
        db.execSQL("INSERT INTO session(id, login) VALUES(1, 'kosong')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS session")
        db.execSQL("DROP TABLE IF EXISTS user")
        onCreate(db)
    }

    //check session
    fun checkSession(sessionValues: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM session WHERE login = ?", arrayOf(sessionValues))
        return if (cursor.count > 0) {
            true
        } else {
            false
        }
    }

    //upgrade session
    fun upgradeSession(sessionValues: String?, id: Int): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("login", sessionValues)
        val update = db.update("session", contentValues, "id=$id", null).toLong()
        return if (update == -1L) {
            false
        } else {
            true
        }
    }

    //insert user
    fun insertUser(email: String?, password: String?): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("email", email)
        contentValues.put("password", password)
        val insert = db.insert("user", null, contentValues)
        return if (insert == -1L) {
            false
        } else {
            true
        }
    }

    //check login
    fun checkLogin(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM user WHERE email = ? AND password = ?",
            arrayOf(email, password)
        )
        return if (cursor.count > 0) {
            true
        } else {
            false
        }
    }
}
