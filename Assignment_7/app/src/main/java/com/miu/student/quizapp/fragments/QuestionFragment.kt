package com.miu.student.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miu.student.quizapp.R
import com.miu.student.quizapp.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

private  lateinit var binding : FragmentQuestionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_question, container, false)
        binding = FragmentQuestionBinding.bind(view)
        return binding.root
    }

}