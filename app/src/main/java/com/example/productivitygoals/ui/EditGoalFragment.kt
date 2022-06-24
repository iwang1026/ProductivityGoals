package com.example.productivitygoals.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.productivitygoals.R
import com.example.productivitygoals.databinding.FragmentEditGoalBinding

class EditGoalFragment : Fragment(R.layout.fragment_edit_goal) {

    private var _binding: FragmentEditGoalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditGoalBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = EditGoalFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}