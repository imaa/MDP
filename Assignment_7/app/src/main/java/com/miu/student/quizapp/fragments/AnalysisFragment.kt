package com.miu.student.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miu.student.quizapp.R
import com.miu.student.quizapp.databinding.FragmentAnalysisBinding

class AnalysisFragment : Fragment() {

private lateinit var binding : FragmentAnalysisBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_analysis, container, false)
        binding = FragmentAnalysisBinding.bind(view)
        binding.apply {

        }
        return binding.root
    }

}