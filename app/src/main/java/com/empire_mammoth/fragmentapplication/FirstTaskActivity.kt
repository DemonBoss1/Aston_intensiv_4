package com.empire_mammoth.fragmentapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.empire_mammoth.fragmentapplication.databinding.ActivityFirstTaskBinding
import com.empire_mammoth.fragmentapplication.databinding.ActivityMainBinding

class FirstTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstTaskBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main, AFragment.newInstance())
            .commit()
    }
}