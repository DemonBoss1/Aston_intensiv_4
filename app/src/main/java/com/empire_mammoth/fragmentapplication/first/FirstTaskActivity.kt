package com.empire_mammoth.fragmentapplication.first

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.empire_mammoth.fragmentapplication.R
import com.empire_mammoth.fragmentapplication.databinding.ActivityFirstTaskBinding

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