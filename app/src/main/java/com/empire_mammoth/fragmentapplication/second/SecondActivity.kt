package com.empire_mammoth.fragmentapplication.second

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.intFloatMapOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.empire_mammoth.fragmentapplication.R
import com.empire_mammoth.fragmentapplication.databinding.ActivitySecondBinding
import com.empire_mammoth.fragmentapplication.first.AFragment

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main, ListFragment.newInstance())
            .commit()
    }
}