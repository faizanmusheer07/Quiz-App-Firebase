package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnLogin.setOnClickListener {
            login()
        }
    }


    private fun login() {
        val email = binding.etEmailAddress.text.toString()
        val password = binding.etPassword.text.toString()


        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(
                this@SignInActivity,
                "Email and Password are not match",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {

                    Toast.makeText(this@SignInActivity, "SuccessFully", Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@SignInActivity, "Authentication Failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            finish()
        }
    }
}