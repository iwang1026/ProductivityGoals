package com.example.productivitygoals.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productivitygoals.databinding.GoalListItemBinding
import com.example.productivitygoals.models.Goal

class GoalListAdapter(private val listOfGoals: List<Goal>) : RecyclerView.Adapter<GoalListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: GoalListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(goal: Goal) {
            binding.goalTitle.text = goal.title
            binding.goalDueDate.text = goal.dueDate
//            binding.goalCompletionCheckbox.isChecked = goal.completed
            binding.goalCategory.text = goal.category
            binding.cardGoal.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GoalListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listOfGoals[position])
    }

    override fun getItemCount(): Int {
        return listOfGoals.size
    }
}