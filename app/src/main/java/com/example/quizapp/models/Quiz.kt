package com.example.quizapp.models

data class Quiz(
    val id: String = "",
    val title: String = "",
    var questions: MutableMap<String, Question> = mutableMapOf()
)
