package com.arfdevs.phincontrainee.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arfdevs.phincontrainee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}