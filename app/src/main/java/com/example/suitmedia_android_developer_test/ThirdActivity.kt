package com.example.suitmedia_android_developer_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.suitmedia_android_developer_test.databinding.ActivityThirdAcivityBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdAcivityBinding

    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdAcivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        setupComponents()
        setupListener()
    }

    private fun initComponents() {
        btnBack = binding.btnBack
    }

    private fun setupComponents() {

    }

    private fun setupListener() {
        btnBack.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}