package com.miu.student.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.miu.student.quizapp.R
import com.miu.student.quizapp.databinding.FragmentResultBinding

// TODO: Rename para
class ResultFragment : Fragment() {
    private lateinit var binding : FragmentResultBinding
    private val nargs: ResultFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_result, container, false)
        binding = FragmentResultBinding.bind(view)
        binding.apply {
            val correctAnswers = nargs.questions.count { it.selectedAnswer?.isCorrect == true }
            val totalQuestions = nargs.questions.size
            val score = (correctAnswers * 100) / totalQuestions
            totalQuestionsTextView.text = "Total Questions: $totalQuestions"
            correctAnswersTextView.text = "Correct Answers: $correctAnswers"
            wrongAnswersTextView.text = "Wrong Answers: ${totalQuestions - correctAnswers}"
            finalScoreTextView.text = "Final Score: $score%"
            tryAgainButton.setOnClickListener {
                nargs.questions.forEach { it.selectedAnswer = null }
                val directions =
                    AnalysisFragmentDirections.actionAnalysisFragmentToHomeFragment()
                findNavController().navigate(directions)
            }
            resultAnalysisButton.setOnClickListener {
                val directions = ResultFragmentDirections.actionResultFragmentToAnalysisFragment(nargs.questions)
                findNavController().navigate(directions)
            }
        }
        return binding.root
    }

}