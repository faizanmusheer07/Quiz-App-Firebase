package com.example.quizapp.utils

import com.example.quizapp.R


object IconPicker {
    val icons = arrayOf(
        R.drawable.exam2,
        R.drawable.exam2,
        R.drawable.exam2,
        R.drawable.exam2,
        R.drawable.exam2,
        R.drawable.exam2,
        R.drawable.exam2,
        R.drawable.exam2
    )
    var currentIcon = 0

    fun getIcon(): Int {
        currentIcon = (currentIcon + 1) % icons.size
        return icons[currentIcon]
    }
}