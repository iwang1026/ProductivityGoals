package com.example.productivitygoals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productivitygoals.databinding.GoalListItemBinding

class GoalListAdapter(private val listOfGoals: List<Goal>) : RecyclerView.Adapter<GoalListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: GoalListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(goal: Goal) {
            binding.goalTitle.text = goal.title
            binding.goalDueDate.text = goal.dueDate
//            binding.goalCompletionCheckbox.isChecked = goal.completed
            binding.goalCategory.text = goal.category
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