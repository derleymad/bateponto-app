package com.github.derleymad.bateponto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnSee : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSee = findViewById(R.id.button)

        btnSee.setOnClickListener{
            startActivity(Intent(this@MainActivity, CalcActivity::class.java))
        }
    }


}