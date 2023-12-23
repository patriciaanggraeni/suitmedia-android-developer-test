package com.example.suitmedia_android_developer_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.suitmedia_android_developer_test.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private lateinit var username: TextView
    private lateinit var btnBack: ImageButton
    private lateinit var btnChooseUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        setupComponents()
        setupListener()
    }

    private fun initComponents() {
        username = binding.name
        btnBack = binding.btnBack
        btnChooseUser = binding.btnChooseUser
    }

    private fun setupComponents() {
        val username = intent.getStringExtra("username")
        this.username.text = username
    }

    private fun setupListener() {
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnChooseUser.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }
}