package com.example.productivitygoals.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.productivitygoals.R
import com.example.productivitygoals.databinding.FragmentAddGoalBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class AddGoalFragment : Fragment(R.layout.fragment_add_goal) {

    private var _binding: FragmentAddGoalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddGoalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpGoalsAdapter()
        setUpDatePicker()
    }

    private fun setUpDatePicker() {
        val dueDatePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Select due date").setSelection(
            MaterialDatePicker.todayInUtcMilliseconds()).build()

        binding.editTextDueDate.setOnClickListener {
            dueDatePicker.show(childFragmentManager, "dueDate")
        }

        //TODO add a restriction to not be able to set a date in the past

        val outputDateFormat = SimpleDateFormat("yyyy MM dd", Locale.getDefault()).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }

        dueDatePicker.addOnPositiveButtonClickListener {
            binding.editTextDueDate.text = outputDateFormat.format(it)
        }
    }

    private fun setUpGoalsAdapter() {
        val listOfCategories = listOf("Exercise", "Learning", "Music") //TODO static for now
        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter(requireContext(),  android.R.layout.simple_spinner_item, listOfCategories)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        binding.spinnerCategory.adapter = spinnerAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}