package com.example.appweather

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<Button>(R.id.btn_search)
        val Text_Search = findViewById<EditText>(R.id.Edt_search1)





        button1.setOnClickListener(View.OnClickListener {
            val name = Text_Search.text.toString()
            val prefences = PreferenceManager.getDefaultSharedPreferences(this).edit().putString("citysaved", name).apply()
            val intent: Intent = Intent(this, NewActivity::class.java)
            startActivity(intent)

        })
    }
}