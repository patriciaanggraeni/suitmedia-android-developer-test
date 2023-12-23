package com.example.suitmedia_android_developer_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.suitmedia_android_developer_test.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var inputName: EditText
    private lateinit var inputPalindrome: EditText
    private lateinit var btnCheckPalindrome: Button
    private lateinit var btnNext: Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        setupComponents()
    }

    private fun initComponents() {
        inputName = binding.inputName
        inputPalindrome = binding.inputPalindrome

        btnNext =  binding.btnNext
        btnCheckPalindrome = binding.btnCheckPalindrome

    }

    private fun setupComponents() {
        var name = ""
        var palindrome = ""
        var message = ""

        btnCheckPalindrome.setOnClickListener {
            name = inputName.text.toString()
            palindrome = inputPalindrome.text.toString()

            message = if (palindrome.isEmpty()) {
                "Input palindrome cannot be empty"
            } else if (isPalindrome(palindrome)) {
                "Is Palindrome"
            } else {
                "Not Palindrome"
            }

            showDialogMessage(message)
        }

        btnNext.setOnClickListener {
            if (name.isNotEmpty() && isPalindrome(palindrome)) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            } else {
                showDialogMessage("Not Palindrome")
            }
        }
    }

    private fun isPalindrome(value: String): Boolean {
        val text = value.replace("\\s".toRegex(), "").lowercase()
        return text == text.reversed()
    }

    private fun showDialogMessage(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Palindrome Check")
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}