package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityIntroScreenBinding
import com.google.firebase.auth.FirebaseAuth

class IntroScreenActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityIntroScreenBinding.inflate(layoutInflater)
    }
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        if (firebaseAuth.currentUser != null) {
            Toast.makeText(
                this@IntroScreenActivity,
                "User is already logged in!",
                Toast.LENGTH_SHORT
            ).show()
            reDirect("Main")
        }
        binding.btnGetStarted.setOnClickListener {
            reDirect("LOGIN")
        }
    }

    private fun reDirect(name: String) {
        val intent = when (name) {
            "LOGIN" -> Intent(this@IntroScreenActivity, SignInActivity::class.java)
            "Main" -> Intent(this@IntroScreenActivity, MainActivity::class.java)
            else -> throw Exception("no path exists")
        }
        startActivity(intent)
        finish()
    }
}

