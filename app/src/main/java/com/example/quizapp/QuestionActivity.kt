package com.example.quizapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.adapter.OptionAdapter
import com.example.quizapp.databinding.ActivityQuestionBinding
import com.example.quizapp.models.Question
import com.example.quizapp.models.Quiz
import com.google.firebase.firestore.FirebaseFirestore

class QuestionActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuestionBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        bindViews()
        setUpFirestore()
    }

    private fun setUpFirestore() {
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("quizzes").whereEqualTo("title", "09-10-2024")
            .get()
            .addOnSuccessListener {
                Log.d("DATA", it.toObjects(Quiz::class.java).toString())
            }
    }

    private fun bindViews() {
        val question = Question(
            "which is the hfff",
            "hffgsdf",
            "fgjjgjg",
            "fjtjgj",
            "hfgjh",
            "hfgjh"
        )
        binding.description.text = question.description
        val optionAdapter = OptionAdapter(this, question)
        binding.optionList.adapter = optionAdapter
        binding.optionList.layoutManager = LinearLayoutManager(this)
        binding.optionList.setHasFixedSize(true)
    }

}