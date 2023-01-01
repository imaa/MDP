package com.miu.student.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miu.student.quizapp.R
import com.miu.student.quizapp.databinding.FragmentResultBinding

// TODO: Rename para
class ResultFragment : Fragment() {
    private lateinit var binding : FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_result, container, false)
        binding = FragmentResultBinding.bind(view)
        return binding.root
    }

}