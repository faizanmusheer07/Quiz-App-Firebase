package com.example.quizapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.databinding.OptionItemsBinding
import com.example.quizapp.models.Question

class OptionAdapter(val context: Context, val question: Question) :
    RecyclerView.Adapter<OptionAdapter.optionViewHolder>() {
    private var options: List<String> =
        listOf(question.option1, question.option2, question.option3, question.option4)

    class optionViewHolder(val binding: OptionItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): optionViewHolder {
        return optionViewHolder(
            OptionItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = options.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: optionViewHolder, position: Int) {
        holder.binding.quizOption.text = options[position]
        holder.itemView.setOnClickListener {
            Toast.makeText(context, options[position], Toast.LENGTH_SHORT).show()
            question.userAnswer = options[position]
            notifyDataSetChanged()
        }
        if (question.userAnswer == options[position]) {
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
            Toast.makeText(context, "show red border", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(context, "show simple border", Toast.LENGTH_SHORT).show()
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)
        }
    }
}