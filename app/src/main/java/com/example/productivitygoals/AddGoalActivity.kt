package com.example.productivitygoals

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.productivitygoals.databinding.ActivityGoalsBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class AddGoalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val listOfCategories = listOf("Exercise", "Learning", "Music") //TODO static for now
        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter(this,  android.R.layout.simple_spinner_item, listOfCategories)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        binding.spinnerCategory.adapter = spinnerAdapter

        setDatePicker()
        setSaveOnClickListener()
    }

    private fun setDatePicker() {
        val dueDatePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Select due date").setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build()

        binding.editTextDueDate.setOnClickListener {
            dueDatePicker.show(supportFragmentManager, "dueDate")
        }

        //TODO add a restriction to not be able to set a date in the past

        val outputDateFormat = SimpleDateFormat("yyyy MM dd", Locale.getDefault()).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }

        dueDatePicker.addOnPositiveButtonClickListener {
            binding.editTextDueDate.text = outputDateFormat.format(it)
        }
    }

    private fun setSaveOnClickListener() {
        binding.buttonSaveGoal.setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


}