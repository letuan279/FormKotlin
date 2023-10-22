package com.example.form2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var registerButton: Button
    private lateinit var termsCheckbox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerButton = findViewById(R.id.button6)
        termsCheckbox = findViewById(R.id.checkbox)

        registerButton.setOnClickListener {
            if (isFormValid()) {
                performRegistration()
            } else {
                Toast.makeText(this, "Please fill in all the information and agree to the Terms of Use.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isFormValid(): Boolean {
        val firstName = findViewById<TextInputEditText>(R.id.first_name).text.toString().trim()
        val lastName = findViewById<TextInputEditText>(R.id.last_name).text.toString().trim()
        val address = findViewById<TextInputEditText>(R.id.address).text.toString().trim()
        val email = findViewById<TextInputEditText>(R.id.email).text.toString().trim()
        val isTermsChecked = findViewById<CheckBox>(R.id.checkbox).isChecked
        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val isGenderSelected = genderGroup.checkedRadioButtonId != -1

        return !firstName.isEmpty() &&
                !lastName.isEmpty() &&
                !address.isEmpty() &&
                !email.isEmpty() &&
                isTermsChecked &&
                isGenderSelected
    }

    private fun performRegistration() {
        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
    }
}
