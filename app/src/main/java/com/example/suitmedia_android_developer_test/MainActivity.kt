package com.example.suitmedia_android_developer_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.suitmedia_android_developer_test.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var btnNext: Button
    private lateinit var btnCheck: Button
    private lateinit var inputName: TextInputEditText
    private lateinit var inputPaindrome: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        setupListener()
    }

    private fun initComponents() {
        inputName = binding.inputName
        inputPaindrome = binding.inputPalindrome

        btnNext = binding.btnNext
        btnCheck = binding.btnCheckPalindrome
    }

    private fun setupListener() {
        var checked = false
        var message = ""
        var username = ""
        var palindrome = ""

        btnCheck.setOnClickListener {
            username = inputName.text.toString()
            palindrome = inputPaindrome.text.toString()

            if (palindrome.isEmpty()) {
                message = "Field palindrome cannot be empty"
            } else if (!isPalindrome(palindrome)) {
                message = "Not Palindrome"
            } else {
                message = "Is Palindrome"
                checked = true
            }

            showDialogMessage(message)

        }

        btnNext.setOnClickListener {
            if (checked && username.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else if (username.isEmpty()) {
                showDialogMessage("Username cannot be empty")
            }
        }
    }

    private fun isPalindrome(text: String): Boolean {
        val cleanedText = text.replace("\\s".toRegex(), "").toLowerCase()
        return cleanedText == cleanedText.reversed()
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