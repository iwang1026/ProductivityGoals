package com.example.productivitygoals

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.productivitygoals.databinding.FragmentGoalListBinding

class GoalListFragment : Fragment() {

    private var _binding: FragmentGoalListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGoalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAddGoal.setOnClickListener {
            val intent = Intent(context, AddGoalActivity::class.java)
            startActivity(intent)
        }
    }

    //need recycler view adapter here

    companion object {
        fun newInstance() = GoalListFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}