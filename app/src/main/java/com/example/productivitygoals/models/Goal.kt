package com.example.productivitygoals.models

data class Goal(val title: String, val category: String, val dueDate: String, val completed: Boolean = false)
