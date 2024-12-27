package com.empire_mammoth.fragmentapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.empire_mammoth.fragmentapplication.databinding.ActivityMainBinding
import com.empire_mammoth.fragmentapplication.first.FirstTaskActivity
import com.empire_mammoth.fragmentapplication.second.SecondActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonTask1.setOnClickListener {
                val intent = Intent(this@MainActivity, FirstTaskActivity::class.java)
                startActivity(intent)
            }
            buttonTask2.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}