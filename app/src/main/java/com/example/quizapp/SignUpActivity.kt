package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnSignUp.setOnClickListener {
            signUp()
        }
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
            finish()
        }

    }

    private fun signUp() {
        val email = binding.etEmailAddress.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()

        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(
                this@SignUpActivity,
                "Email and Password can't be blank",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        if (password != confirmPassword) {
            Toast.makeText(
                this@SignUpActivity,
                "Password and ConfirmPassword do not match",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this@SignUpActivity, "Login SuccessFully", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this@SignUpActivity, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@SignUpActivity, "Error Creating User", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

}