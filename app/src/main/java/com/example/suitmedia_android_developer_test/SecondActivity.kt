package com.example.suitmedia_android_developer_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.suitmedia_android_developer_test.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private lateinit var username: TextView
    private lateinit var btnChooseUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        setupComponents()
    }

    private fun initComponents() {
        username = binding.name
        btnChooseUser = binding.btnChooseUser
    }

    private fun setupComponents() {
        val username = intent.getStringExtra("username")
        this.username.text = username
    }
}