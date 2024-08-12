package com.example.quizapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.QuestionActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.QuizItemBinding
import com.example.quizapp.models.Quiz
import com.example.quizapp.utils.ColorPicker
import com.example.quizapp.utils.IconPicker

class QuizAdapter(val context: Context, var quizzes: List<Quiz>) :
    RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {
    inner class QuizViewHolder(val binding: QuizItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        return QuizViewHolder(
            QuizItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = quizzes.size

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.binding.quizTitle.text = quizzes[position].title
        holder.binding.cardContainer.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.binding.quizIcon.setImageResource(IconPicker.getIcon())
        holder.itemView.setOnClickListener {
            val intent = Intent(context, QuestionActivity::class.java)
            intent.putExtra("DATE", quizzes[position].title)
            context.startActivity(intent)
        }

    }

}